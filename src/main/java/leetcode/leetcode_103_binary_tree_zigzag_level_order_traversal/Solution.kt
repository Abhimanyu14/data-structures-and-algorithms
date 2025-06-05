package leetcode.leetcode_103_binary_tree_zigzag_level_order_traversal

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 *
 * TODO(Abhi) - To revisit
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
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
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
        if (result.size % 2 == 0) {
            result.add(current)
        } else {
            result.add(current.reversed())
        }
    }
    return result
}

private fun main() {

}
