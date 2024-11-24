package leetcode.leetcode_2873_maximum_value_of_an_ordered_triplet_i

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/
 *
 * TODO(Abhi) - To revisit
 *
 * Source - https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/discuss/4111950/JavaC%2B%2BPython-One-Pass-O(n)
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 35.2 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun maximumTripletValue(nums: IntArray): Long {
    var result = 0L
    var maxA = 0L
    var maxAB = 0L
    nums.forEach { num ->
        result = max(result, (maxAB * num))
        maxAB = max(maxAB, (maxA - num))
        maxA = max(maxA, num.toLong())
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/
 *
 * Using brute force
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 22 ms, faster than 50.00%
 * Memory Usage: 37.9 MB, less than 33.33%
 *
 * Time -
 * Space -
 */
private fun maximumTripletValueUsingBruteForce(nums: IntArray): Long {
    var result = 0L
    for (i in 0..nums.lastIndex - 2) {
        for (j in (i + 1)..nums.lastIndex - 1) {
            for (k in (j + 1)..nums.lastIndex) {
                result = max(result, ((nums[i] - nums[j]) * nums[k].toLong()))
            }
        }
    }
    return result
}

private fun main() {

}
