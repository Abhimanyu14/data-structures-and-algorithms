package leetcode.leetcode_3_longest_substring_without_repeating_characters

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - [Set] and Two Pointers
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Google, Meta
 */
private fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty() || s.length == 1) {
        return s.length
    }
    var left = 0
    var right = 0
    var result = 1
    val set = mutableSetOf<Char>()
    set.add(s[left])
    while (right < s.lastIndex) {
        right++
        while (set.contains(s[right])) {
            set.remove(s[left])
            left++
        }
        set.add(s[right])
        result = max(result, right - left + 1)
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Using ArrayDeque
 *
 * Stats
 * Runtime: 224 ms, faster than 38.86%
 * Memory Usage: 38.7 MB, less than 18.41%
 */
private fun lengthOfLongestSubstringUsingArrayDeque(s: String): Int {
    var result = 0
    var i = 0
    val arrayDeque = ArrayDeque<Char>()
    while (i != s.length) {
        while (arrayDeque.contains(s[i])) {
            arrayDeque.removeFirst()
        }
        arrayDeque.add(s[i])
        result = maxOf(result, arrayDeque.size)
        i++
    }
    return result
}

private fun main() {
    val input = "pwwkew"
    val input2 = "bbbbb"
    val input3 = "abcabcbb"
    println(lengthOfLongestSubstring(input))
    println(lengthOfLongestSubstring(input2))
    println(lengthOfLongestSubstring(input3))
}
