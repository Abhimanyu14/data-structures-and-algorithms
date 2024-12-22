package leetcode.leetcode_3185_count_pairs_that_form_a_complete_day_ii

/**
 * leetcode - https://leetcode.com/problems/count-pairs-that-form-a-complete-day-ii/
 *
 * Data Structure - Array
 * Algorithm - Counting
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 533 ms, faster than 100.00%
 * Memory Usage: 110.7 MB, less than 50.00%
 *
 * Time - O(N)
 * Space - O(24)
 */
private fun countCompleteDayPairs(hours: IntArray): Long {
    var result = 0L
    val counter = IntArray(24)
    for (hour in hours) {
        result += counter[(24 - (hour % 24)) % 24]
        counter[hour % 24]++
    }
    return result
}

private fun main() {

}
