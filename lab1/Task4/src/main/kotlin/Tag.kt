
class Tag(
    val name: String
) {
    private val tags = mutableListOf<Tag>()
    fun addTag(tag: Tag): Tag {
        tags.add(tag)
        return this
    }

    private val attributes = mutableListOf<Attribute>()
    fun addAttribute(attribute: Attribute): Tag {
        attributes.add(attribute)
        return this
    }

    override fun toString(): String {
        val builder = StringBuilder().append("<$name ")
        attributes.forEach { builder.append("$it ") }
        builder.append(">\n")
        tags.forEach { builder.append(it) }
        builder.append("</$name>")
        return builder.toString()
    }
}