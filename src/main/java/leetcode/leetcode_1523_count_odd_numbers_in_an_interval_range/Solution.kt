package leetcode.leetcode_1523_count_odd_numbers_in_an_interval_range

/**
 * leetcode - https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 *
 * Using maths calculation
 *
 * Stats
 * Runtime: 141 ms, faster than 90.91%
 * Memory Usage: 32.9 MB, less than 89.77%
 */
private fun countOddsUsingMaths(low: Int, high: Int): Int {
    val x = high - low + 1
    return if (x % 2 == 0 || low % 2 == 0) {
        x / 2
    } else {
        (x / 2) + 1
    }
}

private fun main() {

}
