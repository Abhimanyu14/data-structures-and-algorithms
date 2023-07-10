package leetcode.leet_500_to_599.leet_557_reverse_words_in_a_string_iii

/**
 * leetcode - https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
 * Using string methods - split(), joinToString()
 *
 * Stats
 * Runtime: 266 ms, faster than 82.59%
 * Memory Usage: 37.3 MB, less than 81.09%
 */
private fun reverseWords(s: String): String {
    return s.split(" ").joinToString(" ") { it.reversed() }
}

private fun main() {

}
