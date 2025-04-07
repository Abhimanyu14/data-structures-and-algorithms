package leetcode.leetcode_124_binary_tree_maximum_path_sum

import data_structures_and_algorithms.TreeNode
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Using recursion and nested method
 *
 * Stats
 * Runtime: 229 ms, faster than 95.28%
 * Memory Usage: 39 MB, less than 95.28%
 *
 * Companies - Meta
 */
private fun maxPathSum(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    var result = Integer.MIN_VALUE
    fun gainFromSubTree(root: TreeNode): Int {
        val gainFromLeft = root.left?.let {
            max(gainFromSubTree(it), 0)
        } ?: 0
        val gainFromRight = root.right?.let {
            max(gainFromSubTree(it), 0)
        } ?: 0
        result = max(result, gainFromLeft + gainFromRight + root.`val`)
        return max(gainFromLeft + root.`val`, gainFromRight + root.`val`)
    }
    gainFromSubTree(root)
    return result
}

private fun main() {

}
