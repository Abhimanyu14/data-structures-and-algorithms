package leetcode.leetcode_394_decode_string

import java.util.Stack

/**
 * leetcode - https://leetcode.com/problems/decode-string/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [StringBuilder]
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Google
 */
private fun decodeString(s: String): String {
    var index = 0
    fun decode(): String {
        if (index == s.length) {
            return ""
        }
        return if (s[index].isDigit()) {
            var count = 0
            while (s[index].isDigit()) {
                count = (count * 10) + s[index].digitToInt()
                index++
            }
            index++
            decode().repeat(count) + decode()
        } else {
            val result = StringBuilder()
            while (index <= s.lastIndex && s[index].isLetter()) {
                result.append(s[index])
                index++
            }
            if (index == s.length || s[index] == ']') {
                index++
                result.toString()
            } else {
                result.toString() + decode()
            }
        }
    }
    return decode()
}

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
 *
 * Companies - Google, Meta
 */
private fun decodeString1(s: String): String {
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
