package leetcode.leetcode_545_boundary_of_binary_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/boundary-of-binary-tree/description/
 * Premium Question
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Tree
 * Algorithm -
 *
 * Source - https://youtu.be/0ca1nvR0be4
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun boundaryOfBinaryTree(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }
    if (root.left == null && root.right == null) {
        return listOf(root.`val`)
    }
    val result = mutableListOf<Int>()
    result.add(root.`val`)
    val rightBoundary = mutableListOf<Int>()
    var current = root.left
    while (current != null) {
        if (current.left != null || current.right != null) {
            result.add(current.`val`)
        }
        current = if (current.left != null) {
            current.left
        } else {
            current.right
        }
    }
    fun dfs(node: TreeNode) {
        if (node.left == null && node.right == null) {
            result.add(node.`val`)
        }
        node.left?.let {
            dfs(it)
        }
        node.right?.let {
            dfs(it)
        }
    }
    dfs(root)
    current = root.right
    while (current != null) {
        if (current.left != null || current.right != null) {
            rightBoundary.add(current.`val`)
        }
        current = if (current.right != null) {
            current.right
        } else {
            current.left
        }
    }
    result.addAll(rightBoundary.reversed())
    return result
}

private fun main() {

}
