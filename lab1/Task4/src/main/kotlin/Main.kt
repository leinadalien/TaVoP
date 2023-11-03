import java.io.File

fun main(args: Array<String>) {
    createHtmlTable()
}

private fun createHtmlTable() {
    val htmlFile = File("table.html")
    val table = Tag("html")
        .addTag(Tag("head"))
        .addTag(Tag("body")
            .addTag(Tag("table")
                .addAttribute(Attribute(
                    name = "style",
                    value = "width: 100%; height: 100vh; background: linear-gradient(white, black);")
                )
                .addTag(Tag("tr"))
                .addTag(Tag("tr"))
                .addTag(Tag("tr"))
                .addTag(Tag("tr"))
                .addTag(Tag("tr"))
                .addTag(Tag("tr"))
            )
        )
    htmlFile.writeText(table.toString())
}