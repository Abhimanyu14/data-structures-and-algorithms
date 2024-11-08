package leetcode.leetcode_1816_truncate_sentence

/**
 * leetcode - https://leetcode.com/problems/truncate-sentence/
 *
 * Using StringBuilder
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 75.00%
 * Memory Usage: 34.7 MB, less than 55.56%
 *
 * Time -
 * Space -
 */
private fun truncateSentence(s: String, k: Int): String {
    val result = StringBuilder()
    var spaces = 0
    for (i in s.indices) {
        if (s[i] == ' ') {
            spaces++
            if (spaces == k) {
                return result.toString()
            }
        }
        result.append(s[i])
    }
    return result.toString()
}

private fun main() {

}
