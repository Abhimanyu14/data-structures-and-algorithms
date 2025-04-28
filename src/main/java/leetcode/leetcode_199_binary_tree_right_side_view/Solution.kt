package leetcode.leetcode_199_binary_tree_right_side_view

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * Data Structure - [ArrayDeque] (Queue), Tree
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun rightSideView1(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }
    val result = mutableListOf<Int>()
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    while (queue.isNotEmpty()) {
        var last = 0
        repeat(queue.size) {
            val current = queue.removeFirst()
            last = current.`val`
            current.left?.let {
                queue.addLast(it)
            }
            current.right?.let {
                queue.addLast(it)
            }
        }
        result.add(last)
    }
    return result
}

private fun main() {

}
