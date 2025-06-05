package leetcode.leetcode_159_longest_substring_with_at_most_two_distinct_characters

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 * Premium Question
 *
 * Data Structure - [Map]
 * Algorithm - Counting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N) or O(1) and map has at-most 3 elements
 *
 * Companies - Amazon, Google, Meta
 */
private fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
    var result = 1
    val counter = mutableMapOf<Char, Int>()
    var left = 0
    var right = 0
    while (right <= s.lastIndex) {
        counter[s[right]] = counter.getOrDefault(s[right], 0) + 1
        while (counter.size > 2) {
            if (counter.getOrDefault(s[left], 0) == 1) {
                counter.remove(s[left])
            } else {
                counter[s[left]] = counter.getOrDefault(s[left], 0) - 1
            }
            left++
        }
        result = max(result, right - left + 1)
        right++
    }
    return result
}

private fun main() {

}
