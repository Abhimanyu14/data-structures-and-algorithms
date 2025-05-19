package leetcode.leetcode_2062_count_vowel_substrings_of_a_string

/**
 * TODO(Abhi) - To revisit using Sliding Window
 */

/**
 * leetcode - https://leetcode.com/problems/count-vowel-substrings-of-a-string/
 *
 * TODO(Abhi) - To revisit using Sliding Window
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N^2)
 * Space - O(1)
 *
 * Companies - Google
 */
private fun countVowelSubstringsUsingBruteForce(word: String): Int {
    var result = 0
    val map = mapOf(
        'a' to 0,
        'e' to 1,
        'i' to 2,
        'o' to 3,
        'u' to 4,
    )
    val counter = IntArray(5)
    var isValid = false

    fun checkIfValid(): Boolean {
        for (i in 0..4) {
            if (counter[i] == 0) {
                return false
            }
        }
        return true
    }

    fun reset() {
        isValid = false
        for (i in 0..4) {
            counter[i] = 0
        }
    }

    for (i in word.indices) {
        reset()
        for (j in i..word.lastIndex) {
            if (!map.contains(word[j])) {
                break
            }
            counter[map[word[j]]!!]++
            if (!isValid) {
                isValid = checkIfValid()
            }
            if (isValid) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}
