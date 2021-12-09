package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * pageBlockRelatedArticles#16115a96
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockRelatedArticles() : TLAbsPageBlock() {
    var title: TLAbsRichText = TLTextEmpty()

    var articles: TLObjectVector<TLPageRelatedArticle> = TLObjectVector()

    private val _constructor: String = "pageBlockRelatedArticles#16115a96"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(title: TLAbsRichText, articles: TLObjectVector<TLPageRelatedArticle>) : this() {
        this.title = title
        this.articles = articles
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(title)
        writeTLVector(articles)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        title = readTLObject<TLAbsRichText>()
        articles = readTLVector<TLPageRelatedArticle>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += title.computeSerializedSize()
        size += articles.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockRelatedArticles) return false
        if (other === this) return true

        return title == other.title
                && articles == other.articles
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x16115a96
    }
}
