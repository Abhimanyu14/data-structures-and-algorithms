package leetcode.leetcode_14_longest_common_prefix

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/longest-common-prefix/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - StringBuilder
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 203 ms, faster than 91.13%
 * Memory Usage: 36.8 MB, less than 53.10%
 *
 * Time -
 * Space -
 */
private fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }
    fun isCommonPrefix(len: Int): Boolean {
        val str1 = strs[0].substring(0, len)
        for (i in 1..<strs.size) {
            if (!strs[i].startsWith(str1)) {
                return false
            }
        }
        return true
    }

    var minLen = Int.MAX_VALUE
    for (str in strs) {
        minLen = min(minLen, str.length)
    }
    var left = 1
    var right = minLen
    while (left <= right) {
        val mid = left + ((right - left) / 2)
        if (isCommonPrefix(mid)) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return strs[0].substring(0, (left + right) / 2)
}

/**
 * leetcode - https://leetcode.com/problems/longest-common-prefix/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - StringBuilder
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 203 ms, faster than 91.13%
 * Memory Usage: 36.8 MB, less than 53.10%
 *
 * Time -
 * Space -
 */
private fun longestCommonPrefixUsingVerticalScanning(strs: Array<String>): String {
    val result = StringBuilder()
    for (i in strs[0].indices) {
        val currentChar = strs[0][i]
        var isMatching = true
        for (j in 1..strs.lastIndex) {
            if (i > strs[j].lastIndex || strs[j][i] != currentChar) {
                isMatching = false
                break
            }
        }
        if (isMatching) {
            result.append(currentChar)
        } else {
            break
        }
    }
    return result.toString()
}

/**
 * leetcode - https://leetcode.com/problems/longest-common-prefix/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure -
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 203 ms, faster than 91.13%
 * Memory Usage: 36.8 MB, less than 53.10%
 *
 * Time -
 * Space -
 */
private fun longestCommonPrefixUsingIteration(strs: Array<String>): String {
    var prefix = strs[0]
    var match: Int
    for (i in 1..strs.lastIndex) {
        match = 0
        while (match < prefix.length && match < strs[i].length && strs[i][match] == prefix[match]) {
            match++
        }
        prefix = prefix.substring(0, match)
    }
    return prefix
}

private fun main() {

}
