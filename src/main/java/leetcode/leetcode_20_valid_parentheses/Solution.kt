package leetcode.leetcode_20_valid_parentheses

import java.util.Stack

/**
 * leetcode - https://leetcode.com/problems/valid-parentheses/
 *
 * Using Stack - Array Deque
 *
 * Stats
 * Runtime: 296 ms, faster than 22.56%
 * Memory Usage: 36 MB, less than 21.14%
 */
private fun isValid(s: String): Boolean {
    val map = mapOf(
        ')' to '(',
        '}' to '{',
        ']' to '[',
    )
    val stack = ArrayDeque<Char>()
    s.forEach {
        if (map.contains(it)) {
            if (stack.isEmpty() || stack.removeLast() != map[it]) {
                return false
            }
        } else {
            stack.addLast(it)
        }
    }
    return stack.isEmpty()
}

/**
 * leetcode - https://leetcode.com/problems/valid-parentheses/
 *
 * Using Java Stack
 *
 * Stats
 * Runtime: 8 ms, faster than 66.11%
 * Memory Usage: 34.7 MB, less than 63.73%
 *
 * Time: O(N)
 * Space: O(1)
 */
private fun isValidUsingJavaStack(s: String): Boolean {
    if (s.length % 2 != 0) {
        return false
    }
    val map = mapOf(
        '}' to '{',
        ']' to '[',
        ')' to '('
    )
    val stack = Stack<Char>()
    s.forEach {
        if (map.contains(it)) {
            if (stack.isEmpty()) {
                return false
            }
            if (stack.peek() != map[it]) {
                return false
            }
            stack.pop()
        } else {
            stack.push(it)
        }
    }
    return stack.isEmpty()
}

private fun main() {
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("(]"))
}
