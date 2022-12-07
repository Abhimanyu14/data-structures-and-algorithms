package leetcode.leet_100_to_199.leet_124_binary_tree_maximum_path_sum

import data_structures.data_structures.TreeNode
import kotlin.math.max

/**
 * Using recursion and nested method
 *
 * Stats
 * Runtime: 248 ms, faster than 85.32%
 * Memory Usage: 39.9 MB, less than 88.07%
 */
fun maxPathSum(root: TreeNode?): Int {
    var maxSum = Integer.MIN_VALUE
    fun gainFromSubTree(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val gainFromLeft = max(gainFromSubTree(root.left), 0)
        val gainFromRight = max(gainFromSubTree(root.right), 0)
        maxSum = max(maxSum, gainFromLeft + gainFromRight + root.`val`)
        return max(gainFromLeft + root.`val`, gainFromRight + root.`val`)
    }
    gainFromSubTree(root)
    return maxSum
}

private fun main() {

}
