package leetcode.leetcode_859_buddy_strings

/**
 * leetcode - https://leetcode.com/problems/buddy-strings/
 *
 * Using array and iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 4 ms, faster than 72.73%
 * Memory Usage: 37.8 MB, less than 36.00%
 *
 * Time -
 * Space -
 */
private fun buddyStrings(s: String, goal: String): Boolean {
    if (s.length != goal.length) {
        return false
    }
    var changes = 0
    var prevS: Char? = null
    var prevGoal: Char? = null
    val counter = IntArray(26)
    for (i in s.indices) {
        if (s[i] != goal[i]) {
            changes++
            if (prevS == null) {
                prevGoal = goal[i]
                prevS = s[i]
            } else if (prevS != goal[i] || prevGoal != s[i]) {
                return false
            }
        }
        counter[s[i] - 'a']++
    }
    if (changes == 2) {
        return true
    } else if (changes == 0) {
        return counter.any { it > 1 }
    } else {
        return false
    }
}

private fun main() {

}
