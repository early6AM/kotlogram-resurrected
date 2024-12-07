package com.github.badoualy.telegram.tl.builder.poet

import com.github.badoualy.telegram.tl.builder.parser.*
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.TypeName

internal fun serializeParameter(fieldName: String, fieldTlType: TLType): String = when (fieldTlType) {
    is TLTypeFunctional -> "writeTLMethod($fieldName!!)"
    is TLTypeFlag -> "writeInt($fieldName)"
    is TLTypeFlag2 -> "writeInt($fieldName)"
    is TLTypeConditional -> {
        "doIfMask(${fieldTlType.version}, $fieldName, ${fieldTlType.pow2Value()}) " +
                "{ ${serializeParameter("it", fieldTlType.realType)} }"
    }
    is TLTypeGeneric -> "writeTLVector($fieldName)"
    is TLTypeRaw -> when (fieldTlType.name) {
        "int" -> "writeInt($fieldName)"
        "long" -> "writeLong($fieldName)"
        "double" -> "writeDouble($fieldName)"
        "float" -> "writeFloat($fieldName)"
        "string" -> "writeString($fieldName)"
        "bytes" -> "writeTLBytes($fieldName)"
        "Bool" -> "writeBoolean($fieldName)"
        "true", "false" -> ""
        else -> "writeTLObject($fieldName)"
    }
    else -> throw RuntimeException("Unsupported type $fieldTlType")
}

internal fun deserializeParameter(fieldTlType: TLType, fieldType: TypeName): String = when (fieldTlType) {
    is TLTypeFunctional -> "readTLMethod()"
    is TLTypeFlag -> "readInt()"
    is TLTypeFlag2 -> "readInt()"
    is TLTypeConditional -> {
        val realType = fieldTlType.realType

        if (realType.isTrueFalseFlag()) {
            val conditional: TLTypeConditional = fieldTlType
            "isMask(${conditional.version}, ${conditional.pow2Value()})"
        } else {
            "readIfMask(${fieldTlType.version}, ${fieldTlType.pow2Value()}) " +
                    "{ ${deserializeParameter(realType, fieldType)} }"
        }
    }
    is TLTypeGeneric -> when ((fieldTlType.parameters.first() as TLTypeRaw).name) {
        "int" -> "readTLIntVector()"
        "long" -> "readTLLongVector()"
        "string" -> "readTLStringVector()"
        "bytes" ->  "readTLBytesVector()"
        else -> "readTLVector<%T>()"
    }
    is TLTypeRaw -> when (fieldTlType.name) {
        "int" -> "readInt()"
        "long" -> "readLong()"
        "double" -> "readDouble()"
        "float" -> "readFloat()"
        "string" -> "readString()"
        "bytes" -> "readTLBytes()"
        "Bool" -> "readBoolean()"
        "int128" -> "readBytes(16)"
        "int256" -> "readBytes(32)"
        else -> {
            val className = (fieldType as ClassName).simpleName()
            val isAbstract = className.startsWith("TLAbs", true)
            if (isAbstract) {
                "readTLObject<%1T>()"
            } else {
                "readTLObject<%1T>(%1T::class, %1T.CONSTRUCTOR_ID)"
            }
        }
    }
    else -> throw RuntimeException("Unsupported type $fieldTlType")
}

internal fun computeSizeParameter(fieldName: String, fieldTlType: TLType): String = when (fieldTlType) {
    is TLTypeFunctional -> "$fieldName!!.computeSerializedSize()"
    is TLTypeFlag -> "SIZE_INT32"
    is TLTypeFlag2 -> "SIZE_INT32"
    is TLTypeConditional -> {
        "getIntIfMask(${fieldTlType.version}, $fieldName, ${fieldTlType.pow2Value()}) " +
                "{ ${computeSizeParameter("it", fieldTlType.realType)} }"
    }
    is TLTypeGeneric -> "$fieldName.computeSerializedSize()"
    is TLTypeRaw -> {
        val name = fieldTlType.name
        when (name) {
            "int" -> "SIZE_INT32"
            "long" -> "SIZE_INT64"
            "double" -> "SIZE_DOUBLE"
            "float" -> "SIZE_DOUBLE"
            "string" -> "computeTLStringSerializedSize($fieldName)"
            "bytes" -> "computeTLBytesSerializedSize($fieldName)"
            "Bool" -> "SIZE_BOOLEAN"
            else -> "$fieldName.computeSerializedSize()"
        }
    }
    else -> throw RuntimeException("Unsupported type $fieldTlType")
}