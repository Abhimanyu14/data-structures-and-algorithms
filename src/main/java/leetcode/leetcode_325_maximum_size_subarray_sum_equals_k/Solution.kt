package leetcode.leetcode_325_maximum_size_subarray_sum_equals_k

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Using prefix sum and map
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 132 ms, faster than 80.00%
 * Memory Usage: 70.48 MB, less than 86.67%
 *
 * Time -
 * Space -
 */
private fun maxSubArrayLen(nums: IntArray, k: Int): Int {
    var result = 0
    var prefixSum = 0
    val map = mutableMapOf<Int, Int>()
    nums.forEachIndexed { index, num ->
        prefixSum += num
        if (prefixSum == k) {
            result = index + 1
        }
        if (map.contains(prefixSum - k)) {
            result = max(result, index - map.getOrDefault(prefixSum - k, 0))
        }
        if (!map.contains(prefixSum)) {
            map[prefixSum] = index
        }
    }
    return result
}

private fun main() {

}
