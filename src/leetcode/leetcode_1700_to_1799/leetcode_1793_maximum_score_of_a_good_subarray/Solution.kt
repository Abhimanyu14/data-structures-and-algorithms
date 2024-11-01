package leetcode.leetcode_1700_to_1799.leetcode_1793_maximum_score_of_a_good_subarray

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/maximum-score-of-a-good-subarray/
 *
 * TODO(Abhi) - To revisit
 *
 * Using Greedy
 *
 * Stats
 * Runtime: 461 ms, faster than 100.00%
 * Memory Usage: 55.4 MB, less than 100.00%
 */
private fun maximumScore(nums: IntArray, k: Int): Int {
    var left = k
    var right = k
    var ans = nums[k]
    var currMin = nums[k]
    while (left > 0 || right < nums.lastIndex) {
        currMin = if ((if (left > 0) {
                nums[left - 1]
            } else {
                0
            }) < (if (right < nums.lastIndex) {
                nums[right + 1]
            } else {
                0
            })
        ) {
            right++
            min(currMin, nums[right])
        } else {
            left--
            min(currMin, nums[left])
        }
        ans = max(ans, (currMin * (right - left + 1)))
    }
    return ans
}

private fun main() {

}
