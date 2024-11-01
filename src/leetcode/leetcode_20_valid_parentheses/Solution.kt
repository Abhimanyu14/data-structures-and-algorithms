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
 * Runtime: 271 ms, faster than 26.88%
 * Memory Usage: 34.4 MB, less than 58.79%
 */
private fun isValidUsingJavaStack(s: String): Boolean {
    if (s.length % 2 != 0) {
        return false
    }
    val map = hashMapOf(
        '}' to '{',
        ']' to '[',
        ')' to '('
    )
    val stack = Stack<Char>()
    for (i in s) {
        if (map.containsValue(i)) {
            stack.push(i)
        } else {
            if (stack.isEmpty()) {
                return false
            }
            if (stack.peek() != map[i]) {
                return false
            }
            stack.pop()
        }
    }
    return stack.isEmpty()
}

private fun main() {
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("(]"))
}
