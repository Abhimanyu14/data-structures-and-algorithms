package leetcode.leetcode_1900_to_1999.leetcode_1903_largest_odd_number_in_string

/**
 * leetcode - https://leetcode.com/problems/largest-odd-number-in-string
 *
 * Using greedy
 *
 * Stats
 * Runtime: 208 ms, faster than 88.46%
 * Memory Usage: 39.6 MB, less than 73.08%
 */
private fun largestOddNumber(num: String): String {
    var end = num.lastIndex
    while (end >= 0 && ((num[end] - '0') % 2 == 0)) {
        end--
    }
    return num.substring(0..end)
}

private fun main() {

}
