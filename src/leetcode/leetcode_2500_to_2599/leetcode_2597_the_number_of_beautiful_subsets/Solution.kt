package leetcode.leetcode_2500_to_2599.leetcode_2597_the_number_of_beautiful_subsets

import java.util.TreeMap

/**
 * leetcode - https://leetcode.com/problems/the-number-of-beautiful-subsets/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun beautifulSubsets(nums: IntArray, k: Int): Int {
    var totalCount = 1
    val freqMap: MutableMap<Int, MutableMap<Int, Int>> = TreeMap()

    // Calculate frequencies based on remainder
    for (num in nums) {
        val fr = freqMap.getOrDefault(num % k, TreeMap())
        fr[num] = fr.getOrDefault(num, 0) + 1
        freqMap[num % k] = fr
    }

    // Iterate through each remainder group
    for ((_, value) in freqMap) {
        var prevNum = -k
        var prev2 = 0
        var prev1 = 1
        var curr = 1

        // Iterate through each number in the current remainder group
        for ((num, freq) in value) {
            // Count of subsets skipping the current number
            val skip = prev1


            // Count of subsets including the current number
            // Check if the current number and the previous number
            // form a beautiful pair
            val take = if (num - prevNum == k) {
                ((1 shl freq) - 1) * prev2
            } else {
                ((1 shl freq) - 1) * prev1
            }

            curr = skip + take // Store the total count for the current number
            prev2 = prev1
            prev1 = curr
            prevNum = num
        }
        totalCount *= curr
    }
    return totalCount - 1
}

private fun main() {

}
