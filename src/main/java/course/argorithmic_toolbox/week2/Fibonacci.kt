package course.argorithmic_toolbox.week2

private fun fibonacciRecursion(
    n: Int,
): Int {
    if (n <= 1) {
        return n
    }
    return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2)
}

private fun fibonacciTailRecursion(
    n: Int,
    prev: Int = 0,
    current: Int = 1,
): Int {
    if (n <= 1) {
        return current
    }
    return fibonacciTailRecursion(n - 1, current, prev + current)
}

private fun fibonacciDynamicProblem(
    n: Int,
): Int {
    if (n <= 1) {
        return n
    }
    val dp = mutableListOf<Int>()
    dp.add(0)
    dp.add(1)
    for (i in 2..n) {
        dp.add(dp[i - 1] + dp[i - 2])
    }

    return dp[n]
}

private fun fibonacciTwoPointer(
    n: Int,
): Int {
    if (n <= 1) {
        return n
    }
    var first = 0
    var second = 1
    repeat(n - 1) {
        second += first
        first = second - first
    }
    return second
}

private fun main() {
    println(fibonacciRecursion(20))
    println(fibonacciTailRecursion(20))
    println(fibonacciDynamicProblem(20))
    println(fibonacciTwoPointer(20))
}
