package leetcode.leet_0_to_99.leet_58_length_of_last_word

/**
 * Using string methods
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
 * Stats
 * Runtime: 258 ms, faster than 42.11%
 * Memory Usage: 35.8 MB, less than 68.70%
 */
private fun lengthOfLastWord(s: String): Int {
    var length = 0
    var i = s.lastIndex
    while (s[i].isWhitespace()) {
        i--
    }
    while (i >= 0 && !s[i].isWhitespace()) {
        length++
        i--
    }
    return length
}

fun main() {
    println(lengthOfLastWord("Hello World"))
    println(lengthOfLastWord("   fly me   to   the moon  "))
    println(lengthOfLastWord("luffy is still joyboy"))
    println(lengthOfLastWord("joyboy"))
    println(lengthOfLastWord("joyboy  "))
}
