import kotlin.random.Random

fun main() {
    printTask1()
}

private fun printTask1() {
    println("Hello, world!")
    println("Andhiagain!")
    repeat(Random.nextInt(5, 51)) {
        print('!')
    }
}