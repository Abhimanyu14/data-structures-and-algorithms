package leetcode.leet_200_to_299.leet_263_ugly_number

/**
 * leetcode - https://leetcode.com/problems/ugly-number/
 *
 * Using loops
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 130 ms, faster than 92.86%
 * Memory Usage: 33.5 MB, less than 46.43%
 *
 * Time -
 * Space -
 */
private fun isUgly(n: Int): Boolean {
    var current = n
    while (current % 2 == 0) {
        current /= 2
    }
    while (current % 3 == 0) {
        current /= 3
    }
    while (current % 5 == 0) {
        current /= 5
    }
    return current == 1
}

private fun main() {

}
