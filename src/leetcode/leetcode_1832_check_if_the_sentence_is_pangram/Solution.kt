package leetcode.leetcode_1832_check_if_the_sentence_is_pangram

/**
 * leetcode - https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 *
 * Using set
 *
 * Stats
 * Runtime: 325 ms, faster than 11.34%
 * Memory Usage: 36.8 MB, less than 13.33%
 */
private fun checkIfPangram(sentence: String): Boolean {
    return sentence.toSet().size == 26
}

private fun main() {

}
