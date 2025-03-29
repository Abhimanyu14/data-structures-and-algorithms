package data_structures_and_algorithms.recursion

fun factorial(n: Int): Int {
    if (n == 0 || n == 1) {
        return 1
    }
    return n * factorial(n - 1)
}

fun factorialTailRecursion(n: Int, result: Int): Int {
    if (n == 0 || n == 1) {
        return result
    }
    return factorialTailRecursion(n - 1, result * n)
}

private fun main() {
    // val result = factorial(5)
    val result = factorialTailRecursion(5, 1)
    print(result)
}
