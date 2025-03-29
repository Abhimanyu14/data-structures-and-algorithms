package leetcode.leetcode_543_diameter_of_binary_tree

import data_structures_and_algorithms.TreeNode
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Tree
 * Algorithm - Recursion
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 3 ms, faster than 17.78%
 * Memory Usage: 39.7 MB, less than 23.91%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun diameterOfBinaryTree(root: TreeNode?): Int {
    if (root == null) {
        return -1
    }
    fun findDiameterOfBinaryTree(head: TreeNode): Pair<Int, Int> {
        val (leftLongestPath, leftLongestDiameter) = head.left?.run { findDiameterOfBinaryTree(this) } ?: Pair(0, 0)
        val (rightLongestPath, rightLongestDiameter) = head.right?.run { findDiameterOfBinaryTree(this) } ?: Pair(0, 0)
        return Pair(
            max(leftLongestPath, rightLongestPath) + 1,
            maxOf(leftLongestDiameter, rightLongestDiameter, leftLongestPath + rightLongestPath + 1)
        )
    }
    return findDiameterOfBinaryTree(root).second - 1
}

private fun main() {
}
