package leetcode.leet_20_valid_parentheses

import java.util.Stack

/**
 * Stats
 * Runtime: 271 ms, faster than 26.88%
 * Memory Usage: 34.4 MB, less than 58.79%
 */
fun isValid(s: String): Boolean {
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

fun main() {
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("(]"))
}
