package leetcode.leetcode_1456_maximum_number_of_vowels_in_a_substring_of_given_length

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 *
 * Using sliding window and set
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 46 ms, faster than 52.46%
 * Memory Usage: 39.6 MB, less than 51.03%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun maxVowels(s: String, k: Int): Int {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    var current = 0
    var result = 0
    var index = 0
    while (index < k) {
        if (vowels.contains(s[index])) {
            result++
        }
        index++
    }
    current = result
    while (index < s.length) {
        if (vowels.contains(s[index])) {
            current++
        }
        if (vowels.contains(s[index - k])) {
            current--
        }
        result = max(result, current)
        index++
    }
    return result
}

private fun main() {

}
