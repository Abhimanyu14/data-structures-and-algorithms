package leetcode.leetcode_98_validate_binary_search_tree

import data_structures.TreeNode
import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/validate-binary-search-tree/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 269 ms, faster than 5.11%
 * Memory Usage: 40.6 MB, less than 5.71%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun isValidBST(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }
    fun isValid(current: TreeNode, lower: Long, upper: Long): Boolean {
        if (current.`val` >= upper || current.`val` <= lower) {
            return false
        }
        val left = current.left?.let {
            isValid(it, lower, min(current.`val`.toLong(), upper))
        } ?: true
        val right = current.right?.let {
            isValid(it, max(current.`val`.toLong(), lower), upper)
        } ?: true
        return left && right
    }
    return isValid(root, Int.MIN_VALUE.toLong() - 1, Int.MAX_VALUE.toLong() + 1)
}

private fun isValidBSTUsingNull(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }
    fun isValid(head: TreeNode, min: Int?, max: Int?): Boolean {
        if ((min != null && head.`val` <= min) || (max != null && head.`val` >= max)) {
            return false
        }
        val left = if (head.left == null) {
            true
        } else {
            isValid(head.left!!, min, head.`val`)
        }
        val right = if (head.right == null) {
            true
        } else {
            isValid(head.right!!, head.`val`, max)
        }
        return left && right
    }
    return isValid(root, null, null)
}

private fun main() {

}
