package leetcode.leetcode_2894_divisible_and_non_divisible_sums_difference

/**
 * leetcode - https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/
 *
 * Using maths
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 33.7 MB, less than 63.89%
 *
 * Time -
 * Space -
 */
private fun differenceOfSums(n: Int, m: Int): Int {
    val x = n / m
    return ((n * n) + n - (2 * m * x * x) - (2 * m * x)) / 2
}

private fun main() {

}
