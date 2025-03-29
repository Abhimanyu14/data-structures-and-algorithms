package leetcode.leetcode_2124_check_if_all_as_appears_before_all_bs

/**
 * leetcode - https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
 *
 * Data Structure -
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun checkString(s: String): Boolean {
    var reachedB = false
    var index = 0
    while (index <= s.lastIndex) {
        if (s[index] == 'b') {
            reachedB = true
        } else {
            if (reachedB) {
                return false
            }
        }
        index++
    }
    return true
}

private fun main() {

}
