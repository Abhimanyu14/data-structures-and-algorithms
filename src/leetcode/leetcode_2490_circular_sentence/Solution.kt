package leetcode.leetcode_2490_circular_sentence

/**
 * leetcode - https://leetcode.com/problems/circular-sentence/?envType=daily-question&envId=2024-11-02
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 9 ms, faster than 100.00%
 * Memory Usage: 37.5 MB, less than 50.00%
 *
 * Time -
 * Space -
 */
private fun isCircularSentence(sentence: String): Boolean {
    for (i in 1..<sentence.length) {
        if (sentence[i] == ' ' && sentence[i - 1] != sentence[i + 1]) {
            return false
        }
    }
    return sentence[0] == sentence.last()
}

private fun main() {

}
