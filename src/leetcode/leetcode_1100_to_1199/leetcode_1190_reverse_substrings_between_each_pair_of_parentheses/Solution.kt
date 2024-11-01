package leetcode.leetcode_1100_to_1199.leetcode_1190_reverse_substrings_between_each_pair_of_parentheses

import java.util.Stack

/**
 * leetcode - https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/?envType=daily-question&envId=2024-07-11
 *
 * TODO(Abhi) - To revisit
 *
 * Using Stack
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun reverseParentheses(s: String): String {
    val openParenthesesIndices = Stack<Int>()
    val pair = IntArray(s.length)

    // First pass: Pair up parentheses
    for (i in s.indices) {
        if (s[i] == '(') {
            openParenthesesIndices.push(i)
        }
        if (s[i] == ')') {
            val j = openParenthesesIndices.pop()
            pair[i] = j
            pair[j] = i
        }
    }

    // Second pass: Build the result string
    val result = StringBuilder()
    var currIndex = 0
    var direction = 1
    while (currIndex < s.length) {
        if (s[currIndex] == '(' || s[currIndex] == ')') {
            currIndex = pair[currIndex]
            direction = -direction
        } else {
            result.append(s[currIndex])
        }
        currIndex += direction
    }
    return result.toString()
}

private fun main() {

}
