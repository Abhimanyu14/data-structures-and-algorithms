package leetcode.leetcode_509_fibonacci_number

/**
 * Using two pointer and loops
 *
 * Stats
 * Runtime: 128 ms, faster than 98.52%
 * Memory Usage: 33.1 MB, less than 83.52%
 */
private fun fib(n: Int): Int {
    if (n < 2) {
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

/**
 * Using array and loops
 *
 * Stats
 * Runtime: 147 ms, faster than 86.84%
 * Memory Usage: 32.6 MB, less than 99.26%
 */
private fun fibUsingArray(n: Int): Int {
    if (n < 2) {
        return n
    }
    val result = IntArray(n + 1)
    result[1] = 1
    for (i in 2..n) {
        result[i] = result[i - 1] + result[i - 2]
    }
    return result[n]
}

private fun main() {
    println(fib(2))
    println(fib(3))
    println(fib(4))
}
