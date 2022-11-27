package leetcode.leet_100_to_199.leet_111_minimum_depth_of_binary_tree

import common.data_structures.TreeNode
import kotlin.math.min

/**
 * Using recursion
 *
 * Stats
 * Runtime: 885 ms, faster than 16.99%
 * Memory Usage: 77.9 MB, less than 26.80%
 */
private fun minDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    return if (root.left == null) {
        1 + minDepth(root.right)
    } else if (root.right == null) {
        1 + minDepth(root.left)
    } else {
        1 + min(minDepth(root.left), minDepth(root.right))
    }
}

private fun main() {

}
