package data_structures_and_algorithms.maths

private fun getDigits(n: Int): List<Int> {
    val digits = mutableListOf<Int>()
    var temp = n
    while (temp != 0) {
        digits.add(temp % 10)
        temp /= 10
    }
    return digits.reversed()
}

fun main() {
    println(getDigits(1234))
    println(getDigits(1234567890))
}
