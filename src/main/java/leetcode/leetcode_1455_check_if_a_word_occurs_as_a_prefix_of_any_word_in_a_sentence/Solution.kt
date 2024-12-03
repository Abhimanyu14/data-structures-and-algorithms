package leetcode.leetcode_1455_check_if_a_word_occurs_as_a_prefix_of_any_word_in_a_sentence

/**
 * leetcode - https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 *
 * Data Structure - NA
 * Algorithm - Linear Search
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34.7 MB, less than 93.33%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun isPrefixOfWord(sentence: String, searchWord: String): Int {
    var current = 1
    var i = 0
    var j = 0
    while (i < sentence.length) {
        if (sentence[i] == ' ') {
            current++
            i++
        } else {
            j = 0
            while (i < sentence.length && j < searchWord.length && sentence[i] == searchWord[j]) {
                i++
                j++
            }
            if (j == searchWord.length) {
                return current
            }
            while (i < sentence.length && sentence[i] != ' ') {
                i++
            }
        }
    }
    return -1
}

private fun main() {

}
