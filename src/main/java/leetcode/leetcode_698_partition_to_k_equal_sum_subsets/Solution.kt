package leetcode.leetcode_698_partition_to_k_equal_sum_subsets

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
    val numSum = nums.sum()
    if (numSum % k != 0) {
        return false
    }
    val partitionTotal = numSum / k
    nums.sortDescending()
    if (nums[0] > partitionTotal) {
        return false
    }
    val isUsed = BooleanArray(nums.size)
    fun backtrack(remainingPartitions: Int, startIndex: Int, partitionSum: Int): Boolean {
        if (remainingPartitions == 0) {
            return true
        }
        if (partitionSum == partitionTotal) {
            return backtrack(remainingPartitions - 1, 0, 0)
        }
        for (i in startIndex..nums.lastIndex) {
            if (isUsed[i] || partitionSum + nums[i] > partitionTotal) {
                continue
            }
            isUsed[i] = true
            if (backtrack(remainingPartitions, i + 1, partitionSum + nums[i])) {
                return true
            }
            isUsed[i] = false

            // Optimization: if we fail at first element of current partition
            if (partitionSum == 0) {
                break
            }
        }
        return false
    }
    return backtrack(k, 0, 0)
}

private fun main() {

}
