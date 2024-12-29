package leetcode.leetcode_589_n_ary_tree_preorder_traversal

import data_structures_and_algorithms.Node

/**
 * leetcode - https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 500 ms, faster than 19.14%
 * Memory Usage: 54.8 MB, less than 22.01%
 */
private fun preorder(root: Node?): List<Int> {
    val list = mutableListOf<Int>()
    parseTree(root, list)
    return list
}

private fun parseTree(root: Node?, list: MutableList<Int>) {
    root?.`val`?.let {
        list.add(it)
    }
    root?.children?.forEach {
        parseTree(it, list)
    }
}

private fun main() {
    // println(postorder().joinToString(", "))
}
