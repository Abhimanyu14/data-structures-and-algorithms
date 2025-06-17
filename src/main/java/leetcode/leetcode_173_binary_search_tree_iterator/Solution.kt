package leetcode.leetcode_173_binary_search_tree_iterator

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Binary Search Tree
 * Algorithm - BST Iteration
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
private class BSTIterator(root: TreeNode?) {
    val stack = ArrayDeque<TreeNode>()

    init {
        var current: TreeNode? = root
        while (current != null) {
            stack.addLast(current)
            current = current.left
        }
    }

    fun next(): Int {
        val result = stack.removeLast()
        var current: TreeNode? = result
        current = current?.right
        while (current != null) {
            stack.addLast(current)
            current = current.left
        }
        return result.`val`
    }

    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }
}

private fun main() {

}
