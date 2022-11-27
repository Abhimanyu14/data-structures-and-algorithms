package leetcode.leet_100_to_199.leet_144_binary_tree_preorder_traversal

import common.data_structures.TreeNode

/**
 * Using recursion
 *
 * Stats
 * Runtime: 278 ms, faster than 36.17%
 * Memory Usage: 34.8 MB, less than 38.30%
 */
private fun preorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    parseTree(root, list)
    return list
}

private fun parseTree(root: TreeNode?, list: MutableList<Int>) {
    root?.`val`?.let {
        list.add(it)
    }
    root?.left?.let {
        parseTree(it, list)
    }
    root?.right?.let {
        parseTree(it, list)
    }
}

private fun main() {

}

