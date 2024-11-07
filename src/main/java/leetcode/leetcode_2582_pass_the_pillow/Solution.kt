package leetcode.leetcode_2582_pass_the_pillow

/**
 * leetcode - https://leetcode.com/problems/pass-the-pillow/
 *
 * Using maths - patterns matching
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 116 ms, faster than 100.00%
 * Memory Usage: 32.7 MB, less than 100.00%
 *
 * Time - O(1)
 * Space - O(1)
 */
private fun passThePillow(n: Int, time: Int): Int {
    val rem = time % ((n - 1) * 2)
    return if (rem <= n - 1) {
        rem + 1
    } else {
        (2 * (n - 1)) - rem + 1
    }
}

private fun main() {

}
