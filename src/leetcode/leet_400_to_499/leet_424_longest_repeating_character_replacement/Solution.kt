package leetcode.leet_400_to_499.leet_424_longest_repeating_character_replacement

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Using sliding window
 *
 * Stats
 * Runtime: 237 ms, faster than 21.01%
 * Memory Usage: 38.3 MB, less than 14.29%
 */
private fun characterReplacement(s: String, k: Int): Int {
    val counter = mutableMapOf<Char, Int>()

    fun isValid(): Boolean {
        var maxCount = Integer.MIN_VALUE
        var totalCount = 0
        if (counter.keys.size <= 1) {
            return true
        }
        for ((_, value) in counter) {
            totalCount += value
            maxCount = max(maxCount, value)
        }
        return (totalCount - maxCount) <= k
    }

    var left = 0
    var right = 0
    var result = 1
    counter[s[0]] = 1
    while (right < s.lastIndex) {
        right++
        counter[s[right]] = counter.getOrDefault(s[right], 0) + 1
        while (!isValid()) {
            if (counter.getOrDefault(s[left], 0) == 1) {
                counter.remove(s[left])
            } else {
                counter[s[left]] = counter.getOrDefault(s[left], 0) - 1
            }
            left++
        }
        result = max(result, right - left + 1)
    }

    return result
}

private fun main() {

}
