package leetcode.leetcode_958_check_completeness_of_a_binary_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 *
 * Data Structure - [Tree], [ArrayDeque] (Queue)
 * Algorithm - BFS (Tree traversal)
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
private fun isCompleteTree(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }
    val queue = ArrayDeque<TreeNode>()
    var isEndFound = false
    queue.add(root)
    while (queue.isNotEmpty()) {
        val currentNode = queue.removeFirst()
        if (currentNode.left == null) {
            isEndFound = true
        } else {
            if (isEndFound) {
                return false
            }
            queue.addLast(currentNode.left!!)
        }
        if (currentNode.right == null) {
            isEndFound = true
        } else {
            if (isEndFound) {
                return false
            }
            queue.addLast(currentNode.right!!)
        }
    }
    return true
}

private fun main() {

}
