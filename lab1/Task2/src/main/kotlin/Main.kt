import java.util.Scanner

private const val DEFAULT_QUIT_MESSAGE = "cancel"

fun main() {
    val persons = scanPersons()
    persons.forEach { println(it) }
    printInfo(persons)
}

private fun scanPersons(quitMessage: String = DEFAULT_QUIT_MESSAGE): List<Person> {
    val persons = mutableListOf<Person>()
    val scanner = Scanner(System.`in`)
    println("Enter information about persons, or enter \"$quitMessage\" to finish." +
     "\nFor example: Ben Smith 12")
    var person = scanPerson(scanner, quitMessage)
    while (person != null) {
        persons.add(person)
        person = scanPerson(scanner, quitMessage)
    }
    return persons
}

private fun scanPerson(scanner: Scanner, quitMessage: String): Person? {
    val name = scanner.next()
        .takeIf { it != quitMessage } ?: return null
    val surname = scanner.next()
        .takeIf { it != quitMessage } ?: return null
    val age = scanner.next()
        .takeIf { it != quitMessage }
        ?.let {
            try {
                it.toInt()
            } catch (ex: NumberFormatException) {
                println("incorrect format of age, try again")
                return scanPerson(scanner, quitMessage)
            }
    } ?: return null
    return Person(name, surname, age)
}

private fun printInfo(persons: List<Person>) {
    print("Min age: ${persons.minOf { it.age }}, ")
    print("max age: ${persons.maxOf { it.age }}, ")
    val averageAge = persons.sumOf { it.age }.toFloat() / persons.size
    println("average age: " + "%.2f".format(averageAge))
}
