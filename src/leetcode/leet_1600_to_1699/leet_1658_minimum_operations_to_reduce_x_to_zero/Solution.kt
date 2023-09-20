package leetcode.leet_1600_to_1699.leet_1658_minimum_operations_to_reduce_x_to_zero

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 *
 * Using two pointers
 *
 * Stats
 * Runtime: 502 ms, faster than 50.00%
 * Memory Usage: 55.2 MB, less than 25.00%
 */
private fun minOperations(nums: IntArray, x: Int): Int {
    var current = nums.sum()
    var minimum = Int.MAX_VALUE
    var left = 0

    for (right in nums.indices) {
        current -= nums[right]
        while (current < x && left <= right) {
            current += nums[left]
            left += 1
        }
        if (current == x) {
            minimum = min(minimum, (nums.lastIndex - right + left))
        }
    }
    return if (minimum != Int.MAX_VALUE) {
        minimum
    } else {
        -1
    }
}

private fun main() {

}
