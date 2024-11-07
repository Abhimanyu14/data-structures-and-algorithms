package leetcode.leetcode_456_132_pattern

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/132-pattern/
 *
 * Using stack
 *
 * Stats
 * Runtime: 390 ms, faster than 50.00%
 * Memory Usage: 69.2 MB, less than 12.50%
 */
private fun find132pattern(nums: IntArray): Boolean {
    if (nums.size < 3) {
        return false
    }

    val min = IntArray(nums.size)
    min[0] = nums[0]
    for (i in 1 until nums.size) {
        min[i] = min(min[i - 1], nums[i])
    }

    val stack = ArrayDeque<Int>()
    for (i in nums.indices.reversed()) {
        if (nums[i] > min[i]) {
            while (stack.isNotEmpty() && stack.last() <= min[i]) {
                stack.removeLast()
            }
            if (stack.isNotEmpty() && nums[i] > stack.last()) {
                return true
            }
            stack.addLast(nums[i])
        }
    }
    return false
}

/**
 * leetcode - https://leetcode.com/problems/132-pattern/
 *
 * Using brute force - O(N^3)
 *
 * Stats
 * Time Limit Exceeded
 */
private fun find132patternBruteForce(nums: IntArray): Boolean {
    for (i in 0..nums.lastIndex) {
        for (j in (i + 1)..nums.lastIndex) {
            for (k in (j + 1)..nums.lastIndex) {
                if (nums[i] < nums[j] && nums[i] < nums[k] && nums[j] > nums[k]) {
                    return true
                }
            }
        }
    }
    return false
}

private fun main() {

}
