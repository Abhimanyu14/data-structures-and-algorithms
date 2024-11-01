package leetcode.leetcode_151_reverse_words_in_a_string

/**
 * leetcode - https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * Using string methods
 *
 * Stats
 * Runtime: 218 ms, faster than 30.43%
 * Memory Usage: 37.8 MB, less than 61.05%
 */
private fun reverseWords(s: String): String {
    return s.split(" ").filter { it.isNotBlank() }.reversed().joinToString(" ")
}

private fun main() {

}
