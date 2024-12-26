package leetcode.leetcode_2787_ways_to_express_an_integer_as_sum_of_powers

import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Map
 * Algorithm - Dynamic Programming - Tabulation
 *
 * Source - https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/discuss/3801788/JavaC%2B%2BPython-DP
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 12 ms, faster than 100.00%
 * Memory Usage: 36.2 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun numberOfWays(n: Int, x: Int): Int {
    val memo = IntArray(n + 1)
    memo[0] = 1
    var i = 1
    var iPowX = 1
    while (iPowX <= n) {
        for (j in n downTo iPowX) {
            memo[j] = (memo[j] + memo[j - iPowX]) % 1_000_000_007
        }
        i++
        iPowX = i.toDouble().pow(x).toInt()
    }
    return memo[n]
}

/**
 * leetcode - https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Map
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun numberOfWaysUsingBruteForce(n: Int, x: Int): Int {
    var memo = mutableMapOf<Int, Int>()
    memo[0] = 1
    var i = 1
    var iPowX = 1
    while (iPowX <= n) {
        val map = mutableMapOf<Int, Int>()
        for ((sum, count) in memo) {
            map[sum] = map.getOrDefault(sum, 0) + count
            map[sum + iPowX] = map.getOrDefault(sum + iPowX, 0) + count
        }
        memo = map
        i++
        iPowX = i.toDouble().pow(x).toInt()
    }
    return memo.getOrDefault(n, 0)
}

private fun main() {

}
