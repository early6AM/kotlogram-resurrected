package com.github.badoualy.telegram.tl.builder.parser

object TLDefinitionBuilder {

    private val genericRegex = Regex("([a-zA-Z]+)<([a-zA-Z_.]+)>",
                                     RegexOption.IGNORE_CASE) // Vector<SomeKindOfType>
    private val flagRegex = Regex("([a-zA-Z]+\\d*)\\.(\\d+)\\?([a-zA-Z<>.]+)",
                                  RegexOption.IGNORE_CASE) // flags.0?true
    private val rawRegex = Regex("[a-zA-Z].+")

    private val typeMap = HashMap<String, TLTypeRaw>()

    fun build(pair: Pair<List<TLSchemaParser.ConstructorDef>, List<TLSchemaParser.ConstructorDef>>): TLDefinition {
        typeMap.clear()
        println("${Thread.currentThread().id} Reading TL-Schema...")

        val (typesDef, methodsDef) = pair

        // Create all types
        typesDef.map { it.type }.distinct()
                .map { Pair(it, createConstructorType(it)) }
                .toMap(typeMap)

        // Create all types constructors
        val typesConstructors = typesDef.map {
            println("types: $it")
            TLConstructor(it.name,
                          it.id,
                          it.parameters.map {
                              val tag = it.first
                              val typeName = it.second
                              val flagVersion = when (tag) {
                                  "flags" -> 1
                                  "flags2" -> 2
                                  else -> null
                              }
                              TLParameter(tag, createType(typeName, flagVersion = flagVersion))
                          },
                          typeMap[it.type]!!)
        }

        // Create all methods constructors
        println(methodsDef)
        val methodsConstructors = methodsDef.map {
            TLMethod(it.name,
                     it.id,
                     it.parameters.map {
                         val tag = it.first
                         val typeName = it.second
                         val flagVersion = when (tag) {
                             "flags" -> 1
                             "flags2" -> 2
                             else -> null
                         }
                         TLParameter(tag, createType(typeName, flagVersion = flagVersion))
                     },
                     createType(it.type, isParameter = false))
        }

        // Create abstraction-layer with common supertype for types having multiple constructors
        val supertypes = typeMap.values
                .map { type -> Pair(type, typesConstructors.count { it.tlType == type }) }
                .filter { it.second > 1 }

        val supertypesConstructors = supertypes.map {
            val tlType = it.first
            // Constructors that will have this common abstraction
            val subtypesConstructors = typesConstructors.filter { it.tlType == tlType }

            val forEmptyConstructor = it.second == 2 &&
                    subtypesConstructors.any { it.name.endsWith("empty", true) }

            val params = subtypesConstructors.map { it.parameters }.reduce { l1, l2 ->
                l1.intersect(l2).toList()
            }

            // Update each types parameters: reference are not the same
            subtypesConstructors.flatMap { it.parameters }.filter { params.contains(it) }.forEach {
                if (params.contains(it)) it.inherited = true
            }
            subtypesConstructors.forEach { it.hasSupertype = true }

            TLAbstractConstructor(tlType.name, params, tlType, forEmptyConstructor)
        }

        println("${Thread.currentThread().id} Found ${typesConstructors.size} types")
        println("${Thread.currentThread().id} Found ${methodsConstructors.size} methods")
        println("${Thread.currentThread().id} Found ${supertypesConstructors.size} supertypes")
        println("${Thread.currentThread().id} Found ${supertypesConstructors.count { it.forEmptyConstructor }} (for-empty) supertypes")

        return TLDefinition(supertypesConstructors.sorted(),
                            typesConstructors.sorted(),
                            methodsConstructors.sorted())
    }


    private fun createConstructorType(typeName: String): TLTypeRaw = when {
        typeName.matches(rawRegex) -> TLTypeRaw(typeName)
        else -> throw RuntimeException("Unsupported type $typeName for constructor/method}")
    }

    private fun createType(typeName: String, flagVersion: Int? = null, isParameter: Boolean = true): TLType {
//        println("createType() typeName: $typeName isParameter: $isParameter")
        return when {
            !isParameter && typeName == "X" -> TLTypeAny
            isParameter && typeName == "!X" -> TLTypeFunctional
            isParameter && typeName == "#" && flagVersion == 1 -> TLTypeFlag
            isParameter && typeName == "#" && flagVersion == 2 -> TLTypeFlag2
            isParameter && typeName.matches(flagRegex) -> {
                val groups = flagRegex.matchEntire(typeName)?.groups!!
                val maskName = groups[1]?.value
                    ?: throw RuntimeException("Unknown error with type $typeName")
                val flagVersion = when (maskName) {
                    "flags" -> 1
                    "flags2" -> 2
                    else -> throw RuntimeException("Unknown version of flag $maskName")
                }
                val value = groups[2]?.value?.toInt()
                    ?: throw RuntimeException("Unknown error with type $typeName")
                val realType = groups[3]?.value
                    ?: throw RuntimeException("Unknown error with type $typeName")

                TLTypeConditional(flagVersion, value, createType(realType))
            }

            typeName.matches(genericRegex) -> {
                val groups = genericRegex.matchEntire(typeName)?.groups!!
                val tlName: String = groups[1]?.value
                    ?: throw RuntimeException("Unknown error with type $typeName")
                val genericName: String = groups[2]?.value
                    ?: throw RuntimeException("Unknown error with type $typeName")
                if (SupportedGenericTypes.none { it.equals(tlName, true) })
                    throw RuntimeException("Unsupported generic type $tlName")

                TLTypeGeneric(tlName, arrayOf(createType(genericName)))
            }

            typeName.matches(rawRegex) -> {
                when {
                    BuiltInTypes.contains(typeName) -> TLTypeRaw(typeName)
                    typeMap.containsKey(typeName) -> typeMap[typeName]!!
                    else -> throw RuntimeException("Unknown type $typeName")
                }
            }

            else -> throw RuntimeException("Unsupported type $typeName for" +
                    if (isParameter) "parameter"
                    else "method")
        }
    }

}
