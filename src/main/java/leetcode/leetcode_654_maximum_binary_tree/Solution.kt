package leetcode.leetcode_654_maximum_binary_tree

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/maximum-binary-tree/
 *
 * Using recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 17 ms, faster than 100.00%
 * Memory Usage: 40.1 MB, less than 66.67%
 *
 * Time -
 * Space -
 */
private     fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
    fun constructTree(start: Int, end: Int): TreeNode {
        if (start == end) {
            return TreeNode(nums[start])
        }
        var maxValue = nums[start]
        var maxIndex = start
        for (i in (start + 1)..end) {
            if (nums[i] > maxValue) {
                maxValue = nums[i]
                maxIndex = i
            }
        }
        val node = TreeNode(maxValue)
        if (maxIndex > start) {
            node.left = constructTree(start, maxIndex - 1)
        }
        if (maxIndex < end) {
            node.right = constructTree(maxIndex + 1, end)
        }
        return node
    }
    return constructTree(0, nums.lastIndex)
}

private fun main() {

}
