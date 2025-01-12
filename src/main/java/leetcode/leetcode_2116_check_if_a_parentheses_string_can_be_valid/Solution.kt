package leetcode.leetcode_2116_check_if_a_parentheses_string_can_be_valid

/**
 * leetcode - https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/description/?envType=daily-question&envId=2025-01-12
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Map
 * Algorithm - Recursion - Memoization
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun canBeValidUsingBruteForceWithMemo(s: String, locked: String): Boolean {
    val memo = mutableMapOf<Pair<Int, Int>, Boolean>()
    fun isValid(index: Int, current: Int) : Boolean {
        if (index == s.length) {
            return current == 0
        }
        if (current < 0) {
            return false
        }
        memo[Pair(index, current)]?.let {
            return it
        }
        memo[Pair(index, current)] = if (locked[index] == '1') {
            if (s[index] == '(') {
                isValid(index + 1, current + 1)
            } else {
                isValid(index + 1, current - 1)
            }
        } else {
            isValid(index + 1, current + 1) || isValid(index + 1, current - 1)
        }
        return memo[Pair(index, current)]!!
    }
    return isValid(0, 0)
}

private fun main() {

}
