package leetcode.leetcode_559_maximum_depth_of_n_ary_tree

import data_structures_and_algorithms.Node

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
