package leetcode.leet_0_to_99.leet_58_length_of_last_word

/**
 * leetcode - https://leetcode.com/problems/length-of-last-word/
 *
 * Using string methods
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 210 ms, faster than 76.18%
 * Memory Usage: 36 MB, less than 56.51%
 */
private fun lengthOfLastWordUsingStringMethods(s: String): Int {
    return s.trim().split(" ").last().length
}

/**
 * Using loop
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 157 ms, faster than 50.93%
 * Memory Usage: 37.1 MB, less than 39.63%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun lengthOfLastWord(s: String): Int {
    var result = 0
    var i = s.lastIndex
    while (s[i].isWhitespace()) {
        i--
    }
    while (i >= 0 && !s[i].isWhitespace()) {
        result++
        i--
    }
    return result
}

private fun main() {
    println(lengthOfLastWord("Hello World"))
    println(lengthOfLastWord("   fly me   to   the moon  "))
    println(lengthOfLastWord("luffy is still joyboy"))
    println(lengthOfLastWord("joyboy"))
    println(lengthOfLastWord("joyboy  "))
}
