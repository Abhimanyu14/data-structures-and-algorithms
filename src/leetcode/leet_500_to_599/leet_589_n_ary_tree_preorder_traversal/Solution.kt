package leetcode.leet_500_to_599.leet_589_n_ary_tree_preorder_traversal

import common.data_structures.Node

/**
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
