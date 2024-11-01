package leetcode.leetcode_100_to_199.leetcode_145_binary_tree_postorder_traversal

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * Using recursion
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 129 ms, faster than 97.49%
 * Memory Usage: 34.3 MB, less than 56.78%
 *
 * Time -
 * Space -
 */
private fun postorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    fun parseTree(root: TreeNode?) {
        root?.left?.let {
            parseTree(it)
        }
        root?.right?.let {
            parseTree(it)
        }
        root?.`val`?.let {
            list.add(it)
        }
    }
    parseTree(root)
    return list
}

private fun main() {

}
