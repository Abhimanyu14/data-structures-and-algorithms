package leetcode.leetcode_416_partition_equal_subset_sum

/**
 * leetcode - https://leetcode.com/problems/partition-equal-subset-sum/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Dynamic Programming (Recursion) - Memoization
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(2 ^ N)
 * Space - O(2 ^ N)
 *
 * Companies - Google
 */
private fun canPartitionUsingMemoization(nums: IntArray): Boolean {
    val sum = nums.sum()
    if (sum % 2 != 0) {
        return false
    }
    val cache = mutableMapOf<Pair<Int, Int>, Boolean>()
    fun getSum(index: Int, current: Int): Boolean {
        cache[Pair(index, current)]?.let {
            return it
        }
        if (current == sum / 2) {
            cache[Pair(index, current)] = true
            return true
        }
        if (index == nums.size) {
            cache[Pair(index, current)] = false
            return false
        }
        cache[Pair(index, current)] = getSum(index + 1, current) || getSum(index + 1, current + nums[index])
        return cache[Pair(index, current)]!!
    }
    return getSum(0, 0)
}

/**
 * leetcode - https://leetcode.com/problems/partition-equal-subset-sum/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(2 ^ N)
 * Space - O(2 ^ N)
 *
 * Companies - Google
 */
private fun canPartitionUsingBruteForce(nums: IntArray): Boolean {
    val sum = nums.sum()
    if (sum % 2 != 0) {
        return false
    }
    fun getSum(index: Int, current: Int): Boolean {
        if (current == sum / 2) {
            return true
        }
        if (index == nums.size) {
            return false
        }
        return getSum(index + 1, current) || getSum(index + 1, current + nums[index])
    }
    return getSum(0, 0)
}

private fun main() {

}
