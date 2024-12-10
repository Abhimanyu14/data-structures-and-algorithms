package leetcode.leetcode_394_decode_string

import java.util.Stack

/**
 * leetcode - https://leetcode.com/problems/decode-string/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Stack
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 9 ms, faster than 76.47%
 * Memory Usage: 36.2 MB, less than 45.45%
 *
 * Time -
 * Space -
 */
private fun decodeString(s: String): String {
    val stack = Stack<String>()
    val current = StringBuilder()
    var i = 0
    while (i <= s.lastIndex) {
        if (s[i].isDigit()) {
            while (s[i].isDigit()) {
                current.append(s[i])
                i++
            }
            i++ // Skips '['
        } else {
            if (s[i] == ']') {
                val prev = stack.pop()
                repeat(stack.pop().toInt()) {
                    current.append(prev)
                }
                i++
            } else {
                while (i <= s.lastIndex && s[i].isLetter()) {
                    current.append(s[i])
                    i++
                }
            }
            while (stack.isNotEmpty() && !stack.peek()[0].isDigit()) {
                current.insert(0, stack.pop())
            }
        }
        stack.push(current.toString())
        current.clear()
    }
    return stack.peek()
}

private fun main() {

}
