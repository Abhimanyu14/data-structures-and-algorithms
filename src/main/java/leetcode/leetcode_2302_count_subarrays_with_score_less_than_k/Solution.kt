package leetcode.leetcode_2302_count_subarrays_with_score_less_than_k

/**
 * leetcode - https://leetcode.com/problems/count-subarrays-with-score-less-than-k/description/?envType=daily-question&envId=2025-04-28
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Sliding Window
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Google, Meta
 */
private fun countSubarrays(nums: IntArray, k: Long): Long {
    var result = 0L
    var sum = 0L
    var left = 0
    var right = 0
    while (right <= nums.lastIndex) {
        sum += nums[right]
        while (left <= right && (sum * (right - left + 1) >= k)) {
            sum -= nums[left]
            left++
        }
        result += (right - left + 1)
        right++
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/count-subarrays-with-score-less-than-k/description/?envType=daily-question&envId=2025-04-28
 *
 * Data Structure - NA
 * Algorithm - Binary Search
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Google, Meta
 */
private fun countSubarraysUsingBinarySearch(nums: IntArray, k: Long): Long {
    var result = 0L
    val prefixSum = LongArray(nums.size)
    var sum = 0L
    for (i in nums.indices) {
        sum += nums[i]
        prefixSum[i] = sum
    }
    for (i in nums.indices) {
        var left = i
        var right = nums.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (((prefixSum[mid] - prefixSum[i] + nums[i]) * (mid - i + 1)) >= k) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        result += left - i
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/count-subarrays-with-score-less-than-k/description/?envType=daily-question&envId=2025-04-28
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N^2)
 * Space - O(1)
 *
 * Companies - Google, Meta
 */
private fun countSubarraysUsingBruteForceSolution(nums: IntArray, k: Long): Long {
    var result = 0L
    for (i in nums.indices) {
        var length = 0
        var sum = 0
        for (j in i..nums.lastIndex) {
            sum += nums[j]
            length++
            if (sum * length < k) {
                result++
            } else {
                break
            }
        }
    }
    return result
}

private fun main() {

}
