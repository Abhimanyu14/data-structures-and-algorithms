package leetcode.leetcode_340_longest_substring_with_at_most_k_distinct_characters

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * Premium question
 *
 * Data Structure - Map
 * Algorithm - Sliding Window
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 46 ms, faster than 12.90%
 * Memory Usage: 38.78 MB, less than 16.67%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
    if (k == 0) {
        return 0
    }
    var result = 1
    var left = 0
    var right = 0
    val counter = mutableMapOf<Char, Int>()
    counter[s[0]] = 1
    while (right < s.lastIndex) {
        right++
        counter[s[right]] = counter.getOrDefault(s[right], 0) + 1
        if (counter.size > k) {
            if (counter.getOrDefault(s[left], 0) == 1) {
                counter.remove(s[left])
            } else {
                counter[s[left]] = counter.getOrDefault(s[left], 0) - 1
            }
            left++
        }
        if (counter.size <= k) {
            result = max(result, right - left + 1)
        }
    }
    return result
}

private fun main() {

}
