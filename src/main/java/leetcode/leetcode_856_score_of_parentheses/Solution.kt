package leetcode.leetcode_856_score_of_parentheses

import java.util.Stack

/**
 * leetcode - https://leetcode.com/problems/score-of-parentheses/
 *
 * Using bitwise operators
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 33.9 MB, less than 50.00%
 *
 * Time -
 * Space -
 */
private fun scoreOfParentheses(s: String): Int {
    var result = 0
    var level = 0
    for (i in s.indices) {
        if (s[i] == '(') {
            level++
        } else {
            level--
        }
        if (s[i] == ')' && s[i - 1] == '(') {
            result += 1 shl level
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/score-of-parentheses/
 *
 * Using bitwise operators
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 1 ms, faster than 60.00%
 * Memory Usage: 33.6 MB, less than 81.25%
 *
 * Time -
 * Space -
 */
private fun scoreOfParenthesesUsingStack(s: String): Int {
    val stack = Stack<Int>()
    s.forEach {
        if (it == '(') {
            stack.push(0)
        } else if (it == ')') {
            var temp = stack.pop()
            if (temp == 0) {
                stack.push(1)
            } else {
                var result = temp
                temp = stack.pop()
                while (temp != 0) {
                    result += temp
                    temp = stack.pop()
                }
                stack.push(result * 2)
            }
        }
    }
    var result = 0
    while (stack.isNotEmpty()) {
        result += stack.pop()
    }
    return result
}

private fun main() {

}
