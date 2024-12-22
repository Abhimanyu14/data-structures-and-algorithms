package leetcode.leetcode_2399_check_distances_between_same_letters

/**
 * leetcode - https://leetcode.com/problems/check-distances-between-same-letters/
 *
 * Data Structure - Array
 * Algorithm - Counting
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 37.1 MB, less than 75.00%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun checkDistances(s: String, distance: IntArray): Boolean {
    val prev = IntArray(26) { -1 }
    for (i in s.indices) {
        if (prev[s[i] - 'a'] == -1) {
            prev[s[i] - 'a'] = i
        } else {
            if (distance[s[i] - 'a'] != (i - prev[s[i] - 'a'] - 1)) {
                return false
            }
        }
    }
    return true
}

private fun main() {

}
