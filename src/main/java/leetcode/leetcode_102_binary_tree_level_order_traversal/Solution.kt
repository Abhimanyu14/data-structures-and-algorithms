package leetcode.leetcode_102_binary_tree_level_order_traversal

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/binary-tree-level-order-traversal/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - Tree
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) {
        return emptyList()
    }
    val result = mutableListOf<List<Int>>()
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    while (queue.isNotEmpty()) {
        val queueSize = queue.size
        val current = mutableListOf<Int>()
        for (i in 0..<queueSize) {
            val node = queue.removeFirst()
            current.add(node.`val`)
            node.left?.let {
                queue.addLast(it)
            }
            node.right?.let {
                queue.addLast(it)
            }
        }
        result.add(current)
    }
    return result
}

private fun main() {

}
