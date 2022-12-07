package leetcode.leet_500_to_599.leet_590_n_ary_tree_postorder_traversal

import data_structures.data_structures.Node

/**
 * Using recursion
 *
 * Stats
 * Runtime: 421 ms, faster than 55.00%
 * Memory Usage: 53.5 MB, less than 40.00%
 */
private fun postorder(root: Node?): List<Int> {
    val list = mutableListOf<Int>()
    parseTree(root, list)
    return list
}

private fun parseTree(root: Node?, list: MutableList<Int>) {
    root?.children?.forEach {
        parseTree(it, list)
    }
    root?.`val`?.let {
        list.add(it)
    }
}

private fun main() {
    // println(postorder().joinToString(", "))
}
