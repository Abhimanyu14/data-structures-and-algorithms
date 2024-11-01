package leetcode.leetcode_2400_to_2499.leetcode_2458_height_of_binary_tree_after_subtree_removal_queries

import data_structures_and_algorithms.TreeNode
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/?envType=daily-question&envId=2024-10-26
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 */
private class Solution {
    var currentMaxHeight: Int = 0

    fun treeQueries(root: TreeNode?, queries: IntArray): IntArray {
        traverseLeftToRight(root, 0)
        currentMaxHeight = 0 // Reset for the second traversal
        traverseRightToLeft(root, 0)

        // Process queries and build the result array
        val queryCount = queries.size
        val queryResults = IntArray(queryCount)
        for (i in 0 until queryCount) {
            queryResults[i] = maxHeightAfterRemoval[queries[i]]
        }

        return queryResults
    }

    private fun traverseLeftToRight(node: TreeNode?, currentHeight: Int) {
        if (node == null) return

        // Store the maximum height if this node were removed
        maxHeightAfterRemoval[node.`val`] = currentMaxHeight

        // Update the current maximum height
        currentMaxHeight = max(currentMaxHeight.toDouble(), currentHeight.toDouble()).toInt()

        // Traverse left subtree first, then right
        traverseLeftToRight(node.left, currentHeight + 1)
        traverseLeftToRight(node.right, currentHeight + 1)
    }

    private fun traverseRightToLeft(node: TreeNode?, currentHeight: Int) {
        if (node == null) return

        // Update the maximum height if this node were removed
        maxHeightAfterRemoval[node.`val`] = max(
            maxHeightAfterRemoval[node.`val`].toDouble(),
            currentMaxHeight.toDouble()
        ).toInt()

        // Update the current maximum height
        currentMaxHeight = max(currentHeight.toDouble(), currentMaxHeight.toDouble()).toInt()

        // Traverse right subtree first, then left
        traverseRightToLeft(node.right, currentHeight + 1)
        traverseRightToLeft(node.left, currentHeight + 1)
    }

    companion object {
        // Array to store the maximum height of the tree after removing each node
        val maxHeightAfterRemoval: IntArray = IntArray(100001)
    }
}
private fun main() {

}
