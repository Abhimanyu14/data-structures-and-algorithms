package leetcode.leetcode_557_reverse_words_in_a_string_iii

/**
 * leetcode - https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
 * Using
 *
 * Stats
 * Runtime: 221 ms, faster than 76.09%
 * Memory Usage: 37.5 MB, less than 94.57%
 */
private fun reverseWords(s: String): String {
    var i = 0
    var j = 0
    val result = StringBuilder()
    while (i < s.length) {
        while (i < s.length && s[i] != ' ') {
            i++
        }
        j = i - 1
        if (result.isNotEmpty()) {
            result.append(" ")
        }
        while (j >= 0 && s[j] != ' ') {
            result.append(s[j])
            j--
        }
        i++
    }
    return result.toString()
}

/**
 * leetcode - https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
 * Using functional programming
 * string methods - split(), joinToString()
 *
 * Stats
 * Runtime: 266 ms, faster than 82.59%
 * Memory Usage: 37.3 MB, less than 81.09%
 */
private fun reverseWordsFunctionalProgramming(s: String): String {
    return s.split(" ").joinToString(" ") { it.reversed() }
}

private fun main() {

}
