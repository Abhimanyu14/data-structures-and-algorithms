package leetcode.leetcode_14_longest_common_prefix

/**
 * TODO-Abhi: Revisit using other approaches
 */

/**
 * leetcode - https://leetcode.com/problems/longest-common-prefix/
 *
 * Using loops
 *
 * Stats
 * Runtime: 203 ms, faster than 91.13%
 * Memory Usage: 36.8 MB, less than 53.10%
 */
private fun longestCommonPrefix(strs: Array<String>): String {
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
