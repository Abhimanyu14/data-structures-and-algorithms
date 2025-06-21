package leetcode.leetcode_3085_minimum_deletions_to_make_string_k_special

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/description/?envType=daily-question&envId=2025-06-21
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [IntArray], [List]
 * Algorithm - Counting, Sorting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun minimumDeletions(word: String, k: Int): Int {
    val counter = IntArray(26)
    for (char in word) {
        counter[char - 'a']++
    }
    val sortedFrequency = mutableListOf<Int>()
    for (i in 0..25) {
        if (counter[i] > 0) {
            sortedFrequency.add(counter[i])
        }
    }
    sortedFrequency.sort()
    var result = Int.MAX_VALUE
    for (i in sortedFrequency.first()..sortedFrequency.last()) {
        var current = 0
        for (j in sortedFrequency.indices) {
            if (i - sortedFrequency[j] > k) {
                current += sortedFrequency[j]
            } else if (i < sortedFrequency[j]) {
                current += sortedFrequency[j] - i
            }
        }
        result = min(result, current)
    }
    return result
}

private fun main() {

}
