package leetcode.leet_1000_to_1099.leet_1021_remove_outermost_parentheses

/**
 * leetcode - https://leetcode.com/problems/remove-outermost-parentheses/
 *
 * Using loop
 *
 * Stats
 * Runtime: 177 ms, faster than 100.00%
 * Memory Usage: 35.4 MB, less than 87.50%
 */
private fun removeOuterParentheses(s: String): String {
    val result = StringBuilder()
    var counter = 0
    for (element in s) {
        if (element == '(') {
            if (counter != 0) {
                result.append('(')
            }
            counter++
        } else {
            if (counter != 1) {
                result.append(')')
            }
            counter--
        }
    }
    return result.toString()
}

private fun main() {

}
