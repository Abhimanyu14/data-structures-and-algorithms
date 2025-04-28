package data_structures.recursion

private fun factorial(n: Int): Int {
    if (n == 0 || n == 1) {
        return 1
    }
    return n * factorial(n - 1)
}

private fun factorialTailRecursion(n: Int, result: Int): Int {
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
