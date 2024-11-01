package leetcode.leetcode_700_to_799.leetcode_783_minimum_distance_between_bst_nodes

import data_structures_and_algorithms.TreeNode
import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 *
 * Using BST inorder traversal and loop
 *
 * Stats
 * Runtime: Runtime: 271 ms, faster than 50.00%
 * Memory Usage: 35.6 MB, less than 12.50%
 */
private fun minDiffInBST(root: TreeNode?): Int {
    val result = mutableListOf<Int>()
    fun bstInorderTraversal(current: TreeNode?) {
        current?.left?.let {
            bstInorderTraversal(it)
        }
        current?.`val`?.let {
            result.add(it)
        }
        current?.right?.let {
            bstInorderTraversal(it)
        }
    }
    bstInorderTraversal(root)
    var min = Int.MAX_VALUE
    for (i in 0 until result.lastIndex) {
        if (result[i + 1] - result[i] < min) {
            min = result[i + 1] - result[i]
        }
    }
    return min
}

// Not working
private fun findDiff(root: TreeNode?): Int {
    if (root == null) {
        return Int.MAX_VALUE
    }
    val leftValue = findDiff(root.left)
    val rightValue = findDiff(root.right)
    val leftDiff = abs(root.left?.`val`?.minus(root.`val`) ?: Int.MAX_VALUE)
    val rightDiff = abs(root.right?.`val`?.minus(root.`val`) ?: Int.MAX_VALUE)
    return minOf(leftValue, rightValue, leftDiff, rightDiff)
}

private fun main() {

}
