package leetcode.leetcode_1437_check_if_all_1_s_are_at_least_length_k_places_away

/**
 * leetcode - https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
 *
 * Using
 *
 * Stats
 * Runtime: 411 ms, faster than 100.00%
 * Memory Usage: 48.9 MB, less than 100.00%
 */
private fun kLengthApart(nums: IntArray, k: Int): Boolean {
    var prev = (nums.size + 1) * -1
    for (i in 0..nums.lastIndex) {
        if (nums[i] == 1) {
            if (i - prev - 1 < k) {
                return false
            }
            prev = i
        }
    }
    return true
}

/**
 * TODO-Abhi: To solve using bit manipulation
 */
private fun main() {

}
