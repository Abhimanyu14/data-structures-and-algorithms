package leetcode.leetcode_2942_find_words_containing_character

/**
 * leetcode - https://leetcode.com/problems/find-words-containing-character/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 3 ms, faster than 100.00%
 * Memory Usage: 38.4 MB, less than 94.12%
 *
 * Time -
 * Space -
 */
private fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
    val result = mutableListOf<Int>()
    for (i in words.indices) {
        for (char in words[i]) {
            if (char == x) {
                result.add(i)
                break
            }
        }
    }
    return result
}

private fun main() {

}
