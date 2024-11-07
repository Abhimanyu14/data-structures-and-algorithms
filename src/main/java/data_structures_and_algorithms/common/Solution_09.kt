package data_structures_and_algorithms.common

/**
 * Digits counter
 *
 * Using count { }
 */
private fun digitsCount(str: String): Int {
    return str.count { it.isDigit() }
}

private fun main() {
    println(digitsCount("123asfas214"))
}
