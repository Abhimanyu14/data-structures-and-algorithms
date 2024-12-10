package leetcode.leetcode_1768_merge_strings_alternately

/**
 * leetcode - https://leetcode.com/problems/merge-strings-alternately/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Using string builder
 *
 * Stats
 * Runtime: 142 ms, faster than 81.07%
 * Memory Usage: 34.2 MB, less than 63.44%
 */
private fun mergeAlternately(word1: String, word2: String): String {
    val result = StringBuilder()
    var i = 0
    while (i < word1.length && i < word2.length) {
        result.append(word1[i])
        result.append(word2[i])
        i++
    }
    if (i < word1.length) {
        for (j in i..word1.lastIndex) {
            result.append(word1[j])
        }
    } else {
        for (j in i..word2.lastIndex) {
            result.append(word2[j])
        }
    }
    return result.toString()
}

private fun main() {

}
