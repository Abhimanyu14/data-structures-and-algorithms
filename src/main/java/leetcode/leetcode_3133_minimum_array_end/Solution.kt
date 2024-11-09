package leetcode.leetcode_3133_minimum_array_end

/**
 * leetcode - https://leetcode.com/problems/minimum-array-end/
 *
 * Using OR
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 1725 ms, faster than 33.33%
 * Memory Usage: 34.2 MB, less than 60.00%
 *
 * Time -
 * Space -
 */
private fun minEnd(n: Int, x: Int): Long {
    var result = x.toLong()
    repeat (n - 1) {
        result = (result + 1) or x.toLong()
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/minimum-array-end/
 *
 * Using iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded (TLE)
 *
 * Time -
 * Space -
 */
private fun minEndUsingBruteForce(n: Int, x: Int): Long {
    val longX = x.toLong()
    var result = x.toLong()
    var i = n - 1
    while (i > 0) {
        result++
        if (longX and result == longX) {
            i--
        }
    }
    return result
}

private fun main() {

}
