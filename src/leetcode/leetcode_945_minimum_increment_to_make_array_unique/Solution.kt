package leetcode.leetcode_945_minimum_increment_to_make_array_unique

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 *
 * TODO(Abhi) - To revisit
 *
 * Using counting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun minIncrementForUnique(nums: IntArray): Int {
    val n = nums.size
    var max = 0
    var minIncrements = 0

    // Find maximum value in array to determine range of frequencyCount array
    for (`val` in nums) {
        max = max(max.toDouble(), `val`.toDouble()).toInt()
    }

    // Create a frequencyCount array to store the frequency of each value in nums
    val frequencyCount = IntArray(n + max)

    // Populate frequencyCount array with the frequency of each value in nums
    for (`val` in nums) {
        frequencyCount[`val`]++
    }

    // Iterate over the frequencyCount array to make all values unique
    for (i in frequencyCount.indices) {
        if (frequencyCount[i] <= 1) continue

        // Determine excess occurrences, carry them over to the next value,
        // ensure single occurrence for current value, and update minIncrements.
        val duplicates = frequencyCount[i] - 1
        frequencyCount[i + 1] += duplicates
        frequencyCount[i] = 1
        minIncrements += duplicates
    }

    return minIncrements
}

private fun main() {

}
