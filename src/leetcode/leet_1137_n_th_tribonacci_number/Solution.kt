package leetcode.leet_1137_n_th_tribonacci_number

/**
 * Using two pointer and loops
 *
 * Stats
 * Runtime: 177 ms, faster than 80.00%
 * Memory Usage: 33.2 MB, less than 73.53%
 */
private fun tribonacci(n: Int): Int {
    if (n < 2) {
        return n
    } else if (n == 2) {
        return 1
    }
    var first = 0
    var second = 1
    var third = 1
    repeat(n - 2) {
        third += first + second
        second = third - first - second
        first = third - second - first
    }
    return third
}

/**
 * Using array and loops
 *
 * Stats
 * Runtime: 165 ms, faster than 84.71%
 * Memory Usage: 33.2 MB, less than 73.53%
 */
private fun tribonacciUsingArray(n: Int): Int {
    if (n < 2) {
        return n
    } else if (n == 2) {
        return 1
    }
    val result = IntArray(n + 1)
    result[1] = 1
    result[2] = 1
    for (i in 3..n) {
        result[i] = result[i - 1] + result[i - 2] + result[i - 3]
    }
    return result[n]
}

fun main() {
    println(tribonacci(4))
    println(tribonacci(25))
}
