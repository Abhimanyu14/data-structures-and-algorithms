package leetcode.leet_500_to_599.leet_523_continuous_subarray_sum

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
