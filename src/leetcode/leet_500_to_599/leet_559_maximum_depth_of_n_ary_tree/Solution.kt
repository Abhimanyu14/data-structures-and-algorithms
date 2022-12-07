package leetcode.leet_500_to_599.leet_559_maximum_depth_of_n_ary_tree

import data_structures.data_structures.Node

/**
 * Using recursion
 *
 * Stats
 * Runtime: 201 ms, faster than 100.00%
 * Memory Usage: 37.2 MB, less than 100.00%
 */
private fun maxDepth(root: Node?): Int {
    if (root == null) {
        return 0
    }
    val depths = root.children.map {
        maxDepth(it)
    }
    return 1 + (depths.maxOrNull() ?: 0)
}

private fun main() {

}
