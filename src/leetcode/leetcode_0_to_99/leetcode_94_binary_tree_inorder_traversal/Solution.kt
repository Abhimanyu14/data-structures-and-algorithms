package leetcode.leetcode_0_to_99.leetcode_94_binary_tree_inorder_traversal

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 172 ms, faster than 93.60%
 * Memory Usage: 34.3 MB, less than 81.60%
 */
private fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    fun bstInorderTraversal(current: TreeNode?) {
        current?.left?.let {
            bstInorderTraversal(it)
        }
        current?.`val`?.let {
            result.add(it)
        }
        current?.right?.let {
            bstInorderTraversal(it)
        }
    }
    bstInorderTraversal(root)
    return result
}

private fun main() {

}

