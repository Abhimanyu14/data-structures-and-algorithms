package data_structures_and_algorithms.common

/**
 * Fibonacci
 *
 * Using iteration
 */
private fun fibonacci(n: Int): IntArray {
    val result = IntArray(n)
    result[1] = 1
    for (i in 2..<n) {
        result[i] = result[i - 1] + result[i - 2]
    }
    return result
}

private fun main() {
    println(fibonacci(5).joinToString(", "))
}
