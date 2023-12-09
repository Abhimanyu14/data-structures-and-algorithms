package data_structures_and_algorithms.common

/**
 * Factors of a number
 *
 * Using iteration
 */
private fun factors(n: Int): List<Int> {
    return buildList {
        for (i in 1..n / 2) {
            if (n % i == 0) {
                add(i)
            }
        }
    }
}

private fun main() {
    println(factors(75).joinToString(", "))
}
