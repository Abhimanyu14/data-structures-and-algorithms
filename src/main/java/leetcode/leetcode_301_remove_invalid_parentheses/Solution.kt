package leetcode.leetcode_301_remove_invalid_parentheses

/**
 * leetcode - https://leetcode.com/problems/remove-invalid-parentheses/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [StringBuilder]
 * Algorithm - Backtracking - Recursion
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun removeInvalidParentheses(s: String): List<String> {
    val result = mutableSetOf<String>()
    val current = StringBuilder()
    var maxOpenCount = 0
    fun backtrack(index: Int, openCount: Int, closedCount: Int) {
        if (index == s.length) {
            if (openCount == closedCount) {
                if (openCount > maxOpenCount) {
                    maxOpenCount = openCount
                    result.clear()
                    result.add(current.toString())
                } else if (openCount == maxOpenCount) {
                    result.add(current.toString())
                }
            }
            return
        }
        when {
            s[index] == '(' -> {
                current.append(s[index])
                backtrack(index + 1, openCount + 1, closedCount)
                current.deleteCharAt(current.lastIndex)
            }

            s[index] == ')' -> {
                if (openCount > closedCount) {
                    current.append(s[index])
                    backtrack(index + 1, openCount, closedCount + 1)
                    current.deleteCharAt(current.lastIndex)
                }
            }

            else -> {
                current.append(s[index])
            }
        }
        backtrack(index + 1, openCount, closedCount)
    }
    backtrack(0, 0, 0)
    return result.toList()
}

private fun main() {

}
