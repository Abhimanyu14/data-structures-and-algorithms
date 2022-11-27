package leetcode.leet_100_to_199.leet_104_maximum_depth_of_binary_tree

import common.data_structures.TreeNode
import kotlin.math.max

/**
 * Using recursion
 *
 * Stats
 * Runtime: 273 ms, faster than 78.27%
 * Memory Usage: 37.5 MB, less than 53.72%
 */
private fun maxDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    return 1 + max(maxDepth(root.left), maxDepth(root.right))
}

private fun main() {

}
