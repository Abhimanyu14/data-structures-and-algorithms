package leetcode.leet_200_to_299.leet_222_count_complete_tree_nodes

import data_structures.data_structures.TreeNode
import kotlin.math.max

/**
 * Using recursion
 *
 * Stats
 * Runtime: 390 ms, faster than 68.08%
 * Memory Usage: 48.3 MB, less than 18.08%
 */
private fun countNodesRecursion(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    return 1 + countNodes(root.left) + countNodes(root.right)
}

/**
 * Using recursion - optimized
 *
 * Stats
 * Runtime: 397 ms, faster than 63.03%
 * Memory Usage: 48.7 MB, less than 10.11%
 */
fun countNodes(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    fun count(root: TreeNode?, count: Int): Int {
        if (root?.left == null) {
            return count
        }
        val leftCount = count(root.left, count * 2)
        val rightCount = if (root.right == null) {
            0
        } else {
            count(root.right, (count * 2) + 1)
        }
        return max(leftCount, rightCount)
    }
    return count(root, 1)
}

private fun main() {

}
