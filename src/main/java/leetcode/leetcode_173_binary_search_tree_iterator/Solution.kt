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
    private var currentNode = root
    private val stack = ArrayDeque<TreeNode>()

    init {
        while (currentNode?.left != null) {
            currentNode?.let {
                stack.addLast(it)
            }
            currentNode = currentNode?.left
        }
    }

    fun next(): Int {
        val result = currentNode?.`val` ?: -1
        if (currentNode?.right != null) {
            currentNode = currentNode?.right
            while (currentNode?.left != null) {
                currentNode?.let {
                    stack.addLast(it)
                }
                currentNode = currentNode?.left
            }
        } else {
            currentNode = if (stack.isNotEmpty()) {
                stack.removeLast()
            } else {
                null
            }
        }
        return result
    }

    fun hasNext(): Boolean {
        return currentNode != null
    }
}

private fun main() {

}
