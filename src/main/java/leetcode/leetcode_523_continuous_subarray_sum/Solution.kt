package leetcode.leetcode_523_continuous_subarray_sum

/**
 * leetcode - https://leetcode.com/problems/continuous-subarray-sum/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Map]
 * Algorithm - Hashing, Prefix Sum
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(k)
 *
 * Companies - Meta
 */
private fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
    var prefixSumMod = 0
    val modSeen = mutableMapOf<Int, Int>()
    modSeen[0] = -1
    for (i in nums.indices) {
        prefixSumMod = (prefixSumMod + nums[i]) % k
        if (modSeen.containsKey(prefixSumMod)) {
            if (i - modSeen[prefixSumMod]!! > 1) {
                return true
            }
        } else {
            modSeen[prefixSumMod] = i
        }
    }
    return false
}

/**
 * leetcode - https://leetcode.com/problems/continuous-subarray-sum/
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
private fun checkSubarraySumUsingMap(nums: IntArray, k: Int): Boolean {
    if (nums.size == 1) {
        return false
    }
    var current = nums[0]
    val map = mutableMapOf<Pair<Int, Int>, Int>()
    for (end in 1..nums.lastIndex) {
        current += nums[end]
        if (current % k == 0) {
            return true
        }
        map[Pair(0, end)] = current
    }
    for (start in 1..<nums.lastIndex) {
        for (end in (start + 1)..nums.lastIndex) {
            current = map.getOrDefault(Pair(start - 1, end), 0) - nums[start - 1]
            if (current % k == 0) {
                return true
            }
            map[Pair(start, end)] = current
        }
    }
    return false
}

/**
 * leetcode - https://leetcode.com/problems/continuous-subarray-sum/
 *
 * Using brute force
 *
 * Stats
 * Time Limit Exceeded
 */
private fun checkSubarraySumBruteForce(nums: IntArray, k: Int): Boolean {
    val prefixSum = nums.clone()
    var dist = 1
    while (dist < nums.size) {
        for (i in 0..nums.lastIndex - dist) {
            prefixSum[i] += nums[i + dist]
            if (prefixSum[i] % k == 0) {
                return true
            }
        }
        dist++
    }
    return false
}

private fun main() {

}
