package leetcode.leetcode_2652_sum_multiples

/**
 * leetcode - https://leetcode.com/problems/sum-multiples/
 *
 * Using
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 2 ms, faster than 100.00%
 * Memory Usage: 34 MB, less than 33.33%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun sumOfMultiples(n: Int): Int {
    var result = 0
    for (i in 1..n) {
        if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
            result += i
        }
    }
    return result
}

private fun main() {

}
