package data_structures_and_algorithms.common

/**
 * Char counter
 *
 * Using count { }
 */
private fun countGivenChar(str: String, char: Char): Int {
    return str.count { it == char }
}

private fun main() {
    println(countGivenChar("test", 't'))
}
