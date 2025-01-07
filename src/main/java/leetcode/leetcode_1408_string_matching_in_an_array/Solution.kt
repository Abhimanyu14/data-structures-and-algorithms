package leetcode.leetcode_1408_string_matching_in_an_array

/**
 * leetcode - https://leetcode.com/problems/string-matching-in-an-array/?envType=daily-question&envId=2025-01-07
 *
 * TODO(Abhi) - To revisit using KMP & Trie
 *
 * Data Structure - NA
 * Algorithm - Brute Force
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N ^ 2)
 * Space - O(1)
 */
private fun stringMatching(words: Array<String>): List<String> {
    val result = mutableListOf<String>()
    for (i in words.indices) {
        for (j in words.indices) {
            if (i != j && words[j].contains(words[i])) {
                result.add(words[i])
                break
            }
        }
    }
    return result
}

private fun main() {

}
