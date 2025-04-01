package leetcode.leetcode_129_sum_root_to_leaf_numbers

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/sum-root-to-leaf-numbers/?envType=daily-question&envId=2024-04-15
 *
 * Using recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 41.22 MB, less than 13.42%
 *
 * Time - O(N)
 * Space - O(N) - recursion stack
 *
 * Companies - Meta
 */
private fun sumNumbers(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    fun sumNum(current: TreeNode, num: Int): Int {
        if (current.left == null && current.right == null) {
            return (num * 10) + current.`val`
        }
        val left = current.left?.let {
            sumNum(it, num * 10 + current.`val`)
        } ?: 0
        val right = current.right?.let {
            sumNum(it, num * 10 + current.`val`)
        } ?: 0
        return left + right
    }
    return sumNum(root, 0)
}

private fun main() {

}
