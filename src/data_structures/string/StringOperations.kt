package data_structures.string

fun main() {
    val string = "123"

    string.forEach {
        println(charToDigit(it))
    }
}

fun charToDigit(char: Char): Int {
    return (char - '0')
    // return char.toString().toInt()
}
