package leetcode.leetcode_1300_to_1399.leetcode_1371_find_the_longest_substring_containing_vowels_in_even_counts

import kotlin.math.max

/**
 * leetcode -
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun findTheLongestSubstring(s: String): Int {
    var prefixXOR = 0
    val characterMap = IntArray(26)
    characterMap['a' - 'a'] = 1
    characterMap['e' - 'a'] = 2
    characterMap['i' - 'a'] = 4
    characterMap['o' - 'a'] = 8
    characterMap['u' - 'a'] = 16
    val mp = IntArray(32)
    for (i in 0..31) {
        mp[i] = -1
    }
    var longestSubstring = 0
    for (i in s.indices) {
        prefixXOR = prefixXOR xor characterMap[s[i] - 'a']
        if (mp[prefixXOR] == -1 && prefixXOR != 0) {
            mp[prefixXOR] = i
        }
        longestSubstring = max(longestSubstring, (i - mp[prefixXOR]))
    }
    return longestSubstring
}

private fun main() {

}
