package leetcode.leetcode_20_valid_parentheses

import java.util.Stack

/**
 * leetcode - https://leetcode.com/problems/valid-parentheses/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - [ArrayDeque] (Stack)
 * Algorithm - Stacking
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 23 ms, faster than 21.32%
 * Memory Usage: 46.82 MB, less than 5.13%
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Google, Meta
 */
private fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    val map = mapOf(
        ')' to '(',
        ']' to '[',
        '}' to '{',
    )
    for (char in s) {
        if (map.contains(char)) {
            if (stack.isNotEmpty() && stack.last() == map[char]) {
                stack.removeLast()
            } else {
                return false
            }
        } else {
            stack.addLast(char)
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
