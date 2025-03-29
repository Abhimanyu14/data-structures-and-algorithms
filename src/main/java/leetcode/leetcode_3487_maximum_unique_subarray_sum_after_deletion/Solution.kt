package leetcode.leetcode_3487_maximum_unique_subarray_sum_after_deletion

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/description/
 *
 * Data Structure - [Set]
 * Algorithm - Iteration & Hashing
 *
 * Using [max]
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun maxSum(nums: IntArray): Int {
    var result = 0
    val set = mutableSetOf<Int>()
    var largestNonPositive: Int = Int.MIN_VALUE
    for (num in nums) {
        if (num > 0 && !set.contains(num)) {
            result += num
            set.add(num)
        } else if (num <= 0){
            largestNonPositive = max(largestNonPositive, num)
        }
    }
    return if (result == 0) {
        largestNonPositive
    } else {
        result
    }
}

private fun main() {

}
