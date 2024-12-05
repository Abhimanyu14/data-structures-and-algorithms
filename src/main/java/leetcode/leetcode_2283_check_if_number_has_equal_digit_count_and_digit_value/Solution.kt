package leetcode.leetcode_2283_check_if_number_has_equal_digit_count_and_digit_value

/**
 * leetcode - https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/
 *
 * Data Structure - Map
 * Algorithm - String traversal, Counting
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 3 ms, faster than 66.67%
 * Memory Usage: 35.1 MB, less than 50.00%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun digitCount(num: String): Boolean {
    val counter = mutableMapOf<Int, Int>()
    for (digit in num) {
        counter[digit - '0'] = counter.getOrDefault(digit - '0', 0) + 1
    }
    for (i in num.indices) {
        if (num[i] - '0' != counter.getOrDefault(i, 0)) {
            return false
        }
    }
    return true
}

private fun main() {

}
