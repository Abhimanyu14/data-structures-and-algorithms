package data_structures.string

fun main() {
    val string = "123"

    string.forEach {
        println(charToDigit(it))
    }

    println("abc".repeat(5))
    println("abc".substring(0,1))
}

fun charToDigit(char: Char): Int {
    return (char - '0')
    // return char.toString().toInt()
}
