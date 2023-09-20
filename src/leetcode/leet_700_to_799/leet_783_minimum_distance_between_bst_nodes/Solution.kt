package leetcode.leet_700_to_799.leet_783_minimum_distance_between_bst_nodes

import data_structures_and_algorithms.TreeNode
import leetcode.leet_0_to_99.leet_94_binary_tree_inorder_traversal.bstInorderTraversal
import kotlin.math.abs

/**
 * Using BST inorder traversal and loop
 *
 * Stats
 * Runtime: Runtime: 271 ms, faster than 50.00%
 * Memory Usage: 35.6 MB, less than 12.50%
 *
 */
private fun minDiffInBST(root: TreeNode?): Int {
    val list = mutableListOf<Int>()
    bstInorderTraversal(root, list)
    var min = Int.MAX_VALUE
    for (i in 0 until list.lastIndex) {
        if (list[i + 1] - list[i] < min) {
            min = list[i + 1] - list[i]
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
