package leetcode.leet_500_to_599.leet_543_diameter_of_binary_tree

import data_structures_and_algorithms.TreeNode
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 150 ms, faster than 94.70%
 * Memory Usage: 37.7 MB, less than 19.63%
 */
private fun diameterOfBinaryTree(root: TreeNode?): Int {
    // Longest path, longest diameter
    fun findDiameterOfBinaryTree(head: TreeNode?): Pair<Int, Int> {
        if (head == null) {
            return Pair(0, 0)
        }
        val resultLeft = findDiameterOfBinaryTree(head.left)
        val resultRight = findDiameterOfBinaryTree(head.right)
        return Pair(
            max(resultLeft.first, resultRight.first) + 1,
            max(max(resultLeft.second, resultRight.second), resultLeft.first + resultRight.first + 1)
        )
    }
    return findDiameterOfBinaryTree(root).second - 1
}

private fun main() {
}
