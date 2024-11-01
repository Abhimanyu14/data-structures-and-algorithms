package leetcode.leetcode_796_rotate_string

/**
 * leetcode - https://leetcode.com/problems/rotate-string/
 *
 * TODO(Abhi) - To revisit
 *
 * Using Knuth-Morris-Pratt
 *
 * Stats
 *
 */


/**
 * leetcode - https://leetcode.com/problems/rotate-string/
 *
 * Using simple check
 *
 * Stats
 * Runtime: 140 ms, faster than 81.82%
 * Memory Usage: 35 MB, less than 61.36%
 */
private fun rotateString(s: String, goal: String): Boolean {
    if (s.length != goal.length) {
        return false
    }
    return "$s$s".contains(goal)
}

private fun main() {

}
