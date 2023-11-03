import java.util.Scanner

fun main() {
    scanAndCalculateArea()
}

private fun scanAndCalculateArea() {
    val scanner = Scanner(System.`in`)
    println("Enter the length of the rectangle: ")
    val a = scanSide(scanner)
    println("Enter the width of the rectangle: ")
    val b = scanSide(scanner)
    println("The area of the rectangle is ${a * b}")
}

private fun scanSide(scanner: Scanner): Float = try {
        scanner.nextLine()
            .toFloat()
            .takeIf { it >= 0 }
            ?: showErrorAndTryAgain(scanner)
    } catch (ex: NumberFormatException) {
        showErrorAndTryAgain(scanner)
    }

private fun showErrorAndTryAgain(scanner: Scanner) : Float {
    println("Hmm you did it wrong, just give it another try:")
    return scanSide(scanner)
}