package leetcode.leetcode_2466_count_ways_to_build_good_strings

/**
 * leetcode - https://leetcode.com/problems/count-ways-to-build-good-strings/description/?envType=daily-question&envId=2024-12-30
 *
 * Data Structure - Array
 * Algorithm - Dynamic Programming - Tabulation
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
    val mod = 1_000_000_007
    var result = 0L
    val ways = LongArray(high + 1)
    ways[0] = 1
    for (i in 1..high) {
        if (i - zero >= 0) {
            ways[i] = (ways[i] + ways[i - zero]) % mod
        }
        if (i - one >= 0) {
            ways[i] = (ways[i] + ways[i - one]) % mod
        }
        if (i >= low) {
            result = (result + ways[i]) % mod
        }
    }
    return result.toInt()
}

/**
 * leetcode - https://leetcode.com/problems/count-ways-to-build-good-strings/description/?envType=daily-question&envId=2024-12-30
 *
 * Data Structure - Map
 * Algorithm - Dynamic Programming - Memoization and Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun countGoodStringsUsingBruteForceAndCaching(low: Int, high: Int, zero: Int, one: Int): Int {
    val memo = mutableMapOf<String, Int>()
    fun buildString(current: String): Int {
        memo[current]?.let {
            return it
        }
        var result = if (current.length >= low) {
            1
        } else {
            0
        }
        if (current.length + zero <= high) {
            result = (result + buildString(current + "0".repeat(zero))) % 1_000_000_007
        }
        if (current.length + one <= high) {
            result = (result + buildString(current + "1".repeat(one))) % 1_000_000_007
        }
        memo[current] = result
        return result
    }
    return buildString("")
}

private fun main() {

}
