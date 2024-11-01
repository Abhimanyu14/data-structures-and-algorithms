package leetcode.leetcode_2481_minimum_cuts_to_divide_a_circle

/**
 * leetcode - https://leetcode.com/problems/minimum-cuts-to-divide-a-circle/
 *
 * Using
 *
 * Stats
 * Runtime: 102 ms, faster than 100.00%
 * Memory Usage: 33.3 MB, less than 37.50%
 */
private fun numberOfCuts(n: Int): Int {
    if (n == 1) {
        return 0
    }
    return if (n % 2 == 0) {
        n / 2
    } else {
        n
    }
}

private fun main() {

}
