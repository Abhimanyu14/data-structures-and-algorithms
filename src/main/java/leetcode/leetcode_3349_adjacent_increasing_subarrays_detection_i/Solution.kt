package leetcode.leetcode_3349_adjacent_increasing_subarrays_detection_i

/**
 * leetcode - https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 204 ms, faster than 72.58%
 * Memory Usage: 38.2 MB, less than 35.48%
 *
 * Time -
 * Space -
 */
private fun hasIncreasingSubarrays(nums: List<Int>, k: Int): Boolean {
    if (k == 1 && nums.size >= 2) {
        return true
    }
    var index = 1
    var count = 1
    var prevSet = false
    while (index < nums.size) {
        if (nums[index] > nums[index - 1]) {
            count++
            if ((count == k * 2) || (count == k && prevSet)) {
                return true
            }
        } else {
            prevSet = count >= k
            count = 1
        }
        index++
    }

    return false
}

private fun main() {

}
