import java.io.BufferedInputStream
import java.io.FileOutputStream
import java.net.URL

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("Usage: kotlin Main.kt <URL> <destination folder>")
        return
    }

    val url = args[0]
    val destinationFolder = args[1]
    loadFileFromUrlToFolder(url, destinationFolder)
}

private fun loadFileFromUrlToFolder(url: String, folderPath: String) {
    try {
        // Открываем соединение с URL
        val connection = URL(url).openConnection()
        val inputStream = BufferedInputStream(connection.getInputStream())

        // Извлекаем имя файла из URL
        val fileName = url.substring(url.lastIndexOf("/") + 1)

        // Собираем путь для сохранения файла
        val outputPath = "$folderPath/$fileName"

        // Создаем поток для записи файла
        val fileOutputStream = FileOutputStream(outputPath)
        val buffer = ByteArray(1024)
        var bytesRead: Int

        while (inputStream.read(buffer).also { bytesRead = it } != -1) {
            fileOutputStream.write(buffer, 0, bytesRead)
        }

        fileOutputStream.close()
        inputStream.close()

        println("Файл успешно загружен и сохранен в $outputPath")
    } catch (e: Exception) {
        println("Произошла ошибка: ${e.message}")
    }
}