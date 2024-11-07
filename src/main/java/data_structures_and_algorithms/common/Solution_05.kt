package data_structures_and_algorithms.common

/**
 * Vowels counter
 *
 * Using set
 */
private fun vowelCounter(str: String): Pair<Int, Int> {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    val vowelsCount = str.count { vowels.contains(it) }
    return Pair(vowelsCount, str.length - vowelsCount)
}

private fun main() {
    val result = vowelCounter("ababacadafersa")
    println("Vowels: ${result.first}")
    println("Consonants: ${result.second}")
}
