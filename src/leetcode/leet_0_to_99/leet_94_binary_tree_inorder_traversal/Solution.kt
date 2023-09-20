package leetcode.leet_0_to_99.leet_94_binary_tree_inorder_traversal

import data_structures_and_algorithms.TreeNode

/**
 * Using recursion
 *
 * Stats
 * Runtime: 172 ms, faster than 93.60%
 * Memory Usage: 34.3 MB, less than 81.60%
 */
private fun inorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    bstInorderTraversal(root, list)
    return list
}

fun bstInorderTraversal(root: TreeNode?, list: MutableList<Int>) {
    root?.left?.let {
        bstInorderTraversal(it, list)
    }
    root?.`val`?.let {
        list.add(it)
    }
    root?.right?.let {
        bstInorderTraversal(it, list)
    }
}

private fun main() {

}

