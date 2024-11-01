package leetcode.leetcode_2114_maximum_number_of_words_found_in_sentences

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
 *
 * Using loops, string split()
 *
 * Stats
 * Runtime: 202 ms, faster than 32.98%
 * Memory Usage: 38.3 MB, less than 21.28%
 */
private fun mostWordsFound(sentences: Array<String>): Int {
    var result = 0
    sentences.forEach {
        result = max(result, it.split(" ").size)
    }
    return result
}

private fun main() {

}
