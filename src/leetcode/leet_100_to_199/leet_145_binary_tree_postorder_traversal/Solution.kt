package leetcode.leet_100_to_199.leet_145_binary_tree_postorder_traversal

import data_structures.TreeNode

/**
 * Using recursion
 *
 * Stats
 * Runtime: 360 ms, faster than 5.37%
 * Memory Usage: 34 MB, less than 97.32%
 */
private fun postorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    parseTree(root, list)
    return list
}

private fun parseTree(root: TreeNode?, list: MutableList<Int>) {
    root?.right?.let {
        parseTree(it, list)
    }
    root?.left?.let {
        parseTree(it, list)
    }
    root?.`val`?.let {
        list.add(it)
    }
}

private fun main() {

}
