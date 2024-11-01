package leetcode.leetcode_0_to_99.leetcode_98_validate_binary_search_tree

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 269 ms, faster than 5.11%
 * Memory Usage: 40.6 MB, less than 5.71%
 */
private fun isValidBST(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }
    fun isValid(head: TreeNode, min: Int?, max: Int?): Boolean {
        println("$min $max")
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
