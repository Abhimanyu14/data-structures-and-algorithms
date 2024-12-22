package leetcode.leetcode_3121_count_the_number_of_special_characters_ii

/**
 * leetcode - https://leetcode.com/problems/count-the-number-of-special-characters-ii/
 *
 * Data Structure - Array
 * Algorithm - Counting
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 289 ms, faster than 50.00%
 * Memory Usage: 44 MB, less than 83.33%
 *
 * Time - O(N)
 * Space - O(26)
 */
private fun numberOfSpecialChars(word: String): Int {
    var result = 0
    val lowerIndex = IntArray(26) { -1 }
    val upperIndex = IntArray(26) { -1 }
    for (i in word.indices) {
        if (word[i] in 'a'..'z') {
            lowerIndex[word[i] - 'a'] = i
        } else {
            if (upperIndex[word[i] - 'A'] == -1) {
                upperIndex[word[i] - 'A'] = i
            }
        }
    }
    for (i in 0..25) {
        if (lowerIndex[i] != -1 && upperIndex[i] != -1 && lowerIndex[i] < upperIndex[i]) {
            result++
        }
    }
    return result
}

private fun main() {

}
