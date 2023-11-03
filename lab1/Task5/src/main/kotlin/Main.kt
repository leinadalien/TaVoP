import java.io.File

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("Usage: <program> <folderPath> <extension>")
        return
    }

    val folderPath = args[0]
    val extension = args[1]

    val folder = File(folderPath)
    if (!folder.exists() || !folder.isDirectory) {
        println("Invalid folder path: $folderPath")
        return
    }

    val files = findFilesWithExtension(folder, extension)
    files.forEach { println(it) }
}

fun findFilesWithExtension(folder: File, extension: String): List<String> {
    val fileList = mutableListOf<String>()

    // Рекурсивно идем по указанной папке и подпапкам
    folder.walkTopDown().forEach { file ->
        if (file.isFile && file.extension == extension) {
            fileList.add(file.path)
        }
    }

    return fileList
}