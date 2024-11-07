package leetcode.leetcode_104_maximum_depth_of_binary_tree

import data_structures_and_algorithms.TreeNode
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
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
