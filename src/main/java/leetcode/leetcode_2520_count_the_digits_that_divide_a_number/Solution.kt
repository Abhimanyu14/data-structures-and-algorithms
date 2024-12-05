package leetcode.leetcode_2520_count_the_digits_that_divide_a_number

/**
 * leetcode - https://leetcode.com/problems/count-the-digits-that-divide-a-number/
 *
 * Data Structure - NA
 * Algorithm - Digit extraction
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34.6 MB, less than 5.00%
 *
 * Time - O(log2(N))
 * Space - O(1)
 */
private fun countDigits(num: Int): Int {
    var result = 0
    var temp = num
    while (temp != 0) {
        if (num % (temp % 10) == 0) {
            result++
        }
        temp /= 10
    }
    return result
}

private fun main() {

}
