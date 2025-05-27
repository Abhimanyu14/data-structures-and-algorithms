package leetcode.leetcode_1373_maximum_sum_bst_in_binary_tree

import data_structures.TreeNode
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun maxSumBST(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    var result = 0
    fun maxSumBST(current: TreeNode): Triple<Int, Int, Int>? { // Min, Max, Sum
        val left = current.left?.let {
            maxSumBST(it)
        }
        val right = current.right?.let {
            maxSumBST(it)
        }
        if (
            (current.left != null && left == null) ||
            (current.right != null && right == null) ||
            (left != null && current.`val` <= left.second) ||
            (right != null && current.`val` >= right.first)
        ) {
            return null
        }
        result = max(result, (left?.third ?: 0) + (right?.third ?: 0) + current.`val`)
        return Triple(
            left?.first ?: current.`val`,
            right?.second ?: current.`val`,
            (left?.third ?: 0) + (right?.third ?: 0) + current.`val`,
        )
    }
    maxSumBST(root)
    return result
}

private fun main() {

}
