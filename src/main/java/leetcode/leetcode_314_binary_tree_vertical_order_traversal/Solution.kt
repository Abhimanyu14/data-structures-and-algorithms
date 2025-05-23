package leetcode.leetcode_314_binary_tree_vertical_order_traversal

import data_structures.TreeNode
import java.util.SortedMap

/**
 * leetcode - https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 * Premium question
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [SortedMap], [List], [ArrayDeque] (Queue)
 * Algorithm - BFS
 *
 * Source - https://youtu.be/_Froy1yUCWw
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
private fun verticalOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) {
        return emptyList()
    }
    val sortedMap = sortedMapOf<Int, MutableList<Int>>()
    val queue = ArrayDeque<Pair<TreeNode, Int>>()
    queue.addLast(Pair(root, 0))
    while (queue.isNotEmpty()) {
        val (currentNode, x) = queue.removeFirst()
        sortedMap.computeIfAbsent(x) {
            mutableListOf()
        }.add(currentNode.`val`)
        currentNode.left?.let {
            queue.addLast(Pair(it, x - 1))
        }
        currentNode.right?.let {
            queue.addLast(Pair(it, x + 1))
        }
    }
    return sortedMap.values.toList()
}

private fun main() {

}
