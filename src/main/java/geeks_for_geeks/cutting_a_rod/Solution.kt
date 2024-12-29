package geeks_for_geeks.cutting_a_rod

import kotlin.math.max

/**
 * link - https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 */
fun recursiveSolution(prices: IntArray, length: Int): Int {
    if (length <= 0) {
        return 0
    }
    var result = Int.MIN_VALUE
    for (i in 1..<length) {
        result = max(result, prices[i] + recursiveSolution(prices, length - i - 1))
    }
    return result
}

fun memoizationSolution(prices: IntArray, length: Int, dp: IntArray): Int {
    if (dp[length] >= 0) {
        return dp[length]
    }
    var result: Int
    if (length == 0) {
        result = 0
    } else {
        result = Int.MIN_VALUE
        for (i in 1..<length) {
            result = max(result, prices[i] + memoizationSolution(prices, length - i - 1, dp))
        }
    }
    dp[length] = result
    return result
}

fun memoizationSolutionDriver(prices: IntArray, length: Int): Int {
    val dp = IntArray(length + 1) { -1 }
    return memoizationSolution(prices, length, dp)
}

fun tabulationSolution(prices: IntArray, length: Int): Int {
    val dp = IntArray(length + 1) { -1 }
    dp[0] = 0
    for (i in 1..<length) {
        var result = Int.MIN_VALUE
        for (j in 1..<i) {
            result = max(result, prices[j] + dp[i - j])
        }
        dp[i] = result
    }
    return dp[length]
}

fun main() {
    // println(recursiveSolution(intArrayOf(1, 5, 8, 9, 10, 17, 17, 20), 8))
    // println(memoizationSolutionDriver(intArrayOf(1, 5, 8, 9, 10, 17, 17, 20), 8))
    println(tabulationSolution(intArrayOf(1, 5, 8, 9, 10, 17, 17, 20), 8))
}
