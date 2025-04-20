package leetcode.leetcode_1768_merge_strings_alternately

/**
 * leetcode - https://leetcode.com/problems/merge-strings-alternately/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - [StringBuilder], One Pointer
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(m + n)
 * Space - O(m + n)
 *
 * Companies - Google, Meta
 */
private fun mergeAlternately(word1: String, word2: String): String {
    val result = StringBuilder()
    var index = 0
    while (index < word1.length && index < word2.length) {
        result.append(word1[index])
        result.append(word2[index])
        index++
    }
    while (index < word1.length) {
        result.append(word1[index])
        index++
    }
    while (index < word2.length) {
        result.append(word2[index])
        index++
    }
    return result.toString()
}

private fun main() {

}
