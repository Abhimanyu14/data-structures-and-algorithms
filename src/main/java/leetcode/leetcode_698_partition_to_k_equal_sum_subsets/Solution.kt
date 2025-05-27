package leetcode.leetcode_698_partition_to_k_equal_sum_subsets

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
    var numSum = 0
    var numMax = 0
    for (num in nums) {
        numSum += num
        numMax = max(numMax, num)
    }
    if (numSum % k != 0) {
        return false
    }
    val partitionTotal = numSum / k
    if (numMax > partitionTotal) {
        return false
    }
    // println("numSum: $numSum")
    // println("numMax: $numMax")
    // println("partitionTotal: $partitionTotal")

    val selected = mutableSetOf<Int>()

    fun backtrack(
        remaining: Int,
        index: Int,
        total: Int,
    ): Boolean {
        // println("remaining: $remaining, index: $index, current: $currentSelected, mask: $alreadySelected, total: $total")
        if (remaining == 0) {
            return true
        }
        if (index == nums.size) {
            return false
        }
        if (total == partitionTotal) {
            return backtrack(remaining - 1, 0, 0)
        }
        for (j in nums.indices) {
            if (backtrack(remaining, index + 1, total)) {
                return true
            }
            if (j !in selected && total + nums[j] <= partitionTotal) {
                selected.add(j)
                if (backtrack(remaining, index + 1, total + nums[j])) {
                    return true
                }
                selected.remove(j)
            }
        }
        return false
    }
    return backtrack(k, 0, 0)
}

private fun main() {

}
