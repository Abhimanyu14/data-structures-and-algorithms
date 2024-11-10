package leetcode.leetcode_496_next_greater_element_i

import java.util.Stack

/**
 * leetcode - https://leetcode.com/problems/next-greater-element-i/
 *
 * Using monotonic stack
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 22 ms, faster than 37.10%
 * Memory Usage: 38 MB, less than 41.95%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val nextGreaterElement = mutableMapOf<Int, Int>()
    val stack = Stack<Int>()
    for (i in (nums2.lastIndex) downTo 0) {
        while (stack.isNotEmpty() && stack.peek() < nums2[i]) {
            stack.pop()
        }
        if (stack.isEmpty()) {
            nextGreaterElement[nums2[i]] = -1
        } else {
            nextGreaterElement[nums2[i]] = stack.peek()
        }
        stack.push(nums2[i])
    }
    val result = IntArray(nums1.size)
    nums1.forEachIndexed { index, num1 ->
        result[index] = nextGreaterElement.getOrDefault(num1, 0)
    }
    return result
}

private fun main() {

}
