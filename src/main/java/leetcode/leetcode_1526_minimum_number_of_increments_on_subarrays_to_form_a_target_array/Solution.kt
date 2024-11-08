package leetcode.leetcode_1526_minimum_number_of_increments_on_subarrays_to_form_a_target_array

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
 *
 * Using iteration - single pass
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 20 ms, faster than 16.67%
 * Memory Usage: 52.5 MB, less than 5.88%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun minNumberOperations(target: IntArray): Int {
    var result = target[0]
    for (i in 1..target.lastIndex) {
        if (target[i] > target[i - 1]) {
            result += target[i] - target[i - 1]
        }
    }
    return result
}

private fun main() {

}
