package data_structures.recursion

private fun fibonacciTailRecursion(first: Int, second: Int, n: Int): Int {
    if (n == 0) {
        return first + second
    }
    return fibonacciTailRecursion(second, first + second, n - 1)
}

private fun fibonacciTailRecursionDriver(n: Int): Int {
    return if (n == 0 || n == 1) {
        n
    } else fibonacciTailRecursion(0, 1, n - 2)
}

private fun fibonacciRecursive(n: Int): Int {
    return if (n == 0 || n == 1) {
        n
    } else {
        fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
    }
}

private fun fibonacciIterative(n: Int): Int {
    if (n == 0 || n == 1) {
        return n
    }
    var first = 0
    var second = 1
    for (i in 2..<n) {
        second += first
        first = second - first
    }
    return first + second
}

private fun main() {
    IntArray(10) { it }.forEach {
        // println(fibonacci(it))
        // println(fibonacciIterative(it))
        println(fibonacciTailRecursionDriver(it))
    }
}
