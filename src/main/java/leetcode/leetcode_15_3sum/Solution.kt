package leetcode.leetcode_15_3sum

/**
 * leetcode - https://leetcode.com/problems/3sum/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - 2 Sets
 * Algorithm - Iteration and Hashing
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 1003 ms, faster than 13.46%
 * Memory Usage: 63.6 MB, less than 7.19%
 *
 * Time - O(N ^ 2)
 * Space -
 */
private fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableSetOf<List<Int>>()
    val set = mutableSetOf<Int>()
    for (i in 0..(nums.lastIndex - 1)) {
        set.clear()
        for (j in (i + 1)..nums.lastIndex) {
            if (set.contains(nums[i] + nums[j])) {
                result.add(listOf(nums[i], nums[j], -(nums[i] + nums[j])).sorted())
            }
            set.add(-nums[j])
        }
    }
    return result.toList()
}


/**
 * leetcode - https://leetcode.com/problems/3sum/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - NA
 * Algorithm - Brute Force
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N ^ 3)
 * Space -
 */
private fun threeSumUsingBruteForce(nums: IntArray): List<List<Int>> {
    val result = mutableSetOf<List<Int>>()
    for (i in 0..(nums.lastIndex - 2)) {
        for (j in (i + 1)..(nums.lastIndex - 1)) {
            for (k in (j + 1)..nums.lastIndex) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(listOf(nums[i], nums[j], nums[k]).sorted())
                }
            }
        }
    }
    return result.toList()
}

private fun main() {

}
