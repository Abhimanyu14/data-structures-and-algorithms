package leetcode.leetcode_796_rotate_string

/**
 * leetcode - https://leetcode.com/problems/rotate-string/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [String]
 * Algorithm - Using Knuth-Morris-Pratt
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies -
 */


/**
 * leetcode - https://leetcode.com/problems/rotate-string/
 *
 * Data Structure - [String]
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies -
 */
private fun rotateString(s: String, goal: String): Boolean {
    if (s.length != goal.length) {
        return false
    }
    return "$s$s".contains(goal)
}

private fun main() {

}
