package leetcode.leetcode_3120_count_the_number_of_special_characters_i

/**
 * leetcode - https://leetcode.com/problems/count-the-number-of-special-characters-i/
 *
 * Data Structure - BooleanArray
 * Algorithm - Counting
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 35.5 MB, less than 95.65%
 *
 * Time - O(N)
 * Space - O(26)
 */
private fun numberOfSpecialChars(word: String): Int {
    var result = 0
    val lower = BooleanArray(26)
    val upper = BooleanArray(26)
    for (i in word.indices) {
        if (word[i] in 'a'..'z') {
            lower[word[i] - 'a'] = true
        } else {
            upper[word[i] - 'A'] = true
        }
    }
    for (i in 0..25) {
        if (lower[i] && upper[i]) {
            result++
        }
    }
    return result
}

private fun main() {

}
