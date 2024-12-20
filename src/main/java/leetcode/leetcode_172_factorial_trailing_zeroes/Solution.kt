package leetcode.leetcode_172_factorial_trailing_zeroes

/**
 * leetcode - https://leetcode.com/problems/factorial-trailing-zeroes/
 *
 * Data Structure - NA
 * Algorithm - Maths - Factorial
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34.4 MB, less than 19.23%
 *
 * Time - O(1)
 * Space - O(1)
 */
private fun trailingZeroes(n: Int): Int {
    return (n / 5) + (n / 25) + (n / 125) + (n / 625) + (n / 3125)
}

private fun main() {

}
