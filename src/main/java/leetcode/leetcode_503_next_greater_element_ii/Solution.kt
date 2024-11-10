package leetcode.leetcode_503_next_greater_element_ii

import java.util.Stack

/**
 * leetcode - https://leetcode.com/problems/next-greater-element-ii/
 *
 * Using monotonic stack and index simulation for double array
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 24 ms, faster than 55.56%
 * Memory Usage: 41.4 MB, less than 72.73%
 *
 * Time -
 * Space -
 */
private fun nextGreaterElements(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    val stack = Stack<Int>()
    for (i in (nums.size * 2 - 1) downTo 0) {
        while (stack.isNotEmpty() && stack.peek() <= nums[i % nums.size]) {
            stack.pop()
        }
        if (stack.isEmpty()) {
            result[i % nums.size] = -1
        } else {
            result[i % nums.size] = stack.peek()
        }
        stack.push(nums[i % nums.size])
    }
    return result
}

private fun main() {

}
