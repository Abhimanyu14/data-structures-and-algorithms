package leetcode.leetcode_1711_count_good_meals

/**
 * leetcode - https://leetcode.com/problems/count-good-meals/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */

/**
 * leetcode - https://leetcode.com/problems/count-good-meals/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N ^ 2)
 * Space -
 */
private fun countPairs(deliciousness: IntArray): Int {
    fun isPowerOfTwo(x: Int): Boolean {
        return (x != 0) && ((x and (x - 1)) == 0)
    }

    var result = 0
    for (i in 0..<deliciousness.lastIndex) {
        for (j in (i + 1)..deliciousness.lastIndex) {
            if (isPowerOfTwo(deliciousness[i] + deliciousness[j])) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}
