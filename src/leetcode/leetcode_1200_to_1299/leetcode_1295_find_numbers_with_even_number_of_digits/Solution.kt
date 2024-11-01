package leetcode.leetcode_1200_to_1299.leetcode_1295_find_numbers_with_even_number_of_digits

/**
 * leetcode - https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 *
 * Using map, toString(), length, filter and count
 *
 * Stats
 * Runtime: 312 ms, faster than 69.63%
 * Memory Usage: 37.8 MB, less than 74.81%
 */
private fun findNumbersUsingMultipleOperators(nums: IntArray): Int {
    return nums.map { it.toString().length % 2 == 0 }.filter { it }.count()
}

/**
 * leetcode - https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 *
 * Using count lambda
 *
 * Stats
 * Runtime: 324 ms, faster than 59.26%
 * Memory Usage: 39.8 MB, less than 29.63%
 */
private fun findNumbers(nums: IntArray): Int {
    return nums.count { it.toString().length % 2 == 0 }
}

private fun main() {

}
