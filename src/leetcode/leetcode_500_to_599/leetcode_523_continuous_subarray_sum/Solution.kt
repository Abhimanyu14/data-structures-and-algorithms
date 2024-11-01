package leetcode.leetcode_500_to_599.leetcode_523_continuous_subarray_sum

/**
 * leetcode - https://leetcode.com/problems/continuous-subarray-sum/
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
private fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
    var prefixMod = 0
    val modSeen = HashMap<Int, Int>()
    modSeen[0] = -1
    for (i in nums.indices) {
        prefixMod = (prefixMod + nums[i]) % k
        if (modSeen.containsKey(prefixMod)) {
            if (i - modSeen[prefixMod]!! > 1) {
                return true
            }
        } else {
            modSeen[prefixMod] = i
        }
    }
    return false
}

/**
 * leetcode - https://leetcode.com/problems/continuous-subarray-sum/
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
