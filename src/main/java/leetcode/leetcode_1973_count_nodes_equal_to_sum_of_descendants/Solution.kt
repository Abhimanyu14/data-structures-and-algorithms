package leetcode.leetcode_1973_count_nodes_equal_to_sum_of_descendants

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/count-nodes-equal-to-sum-of-descendants/description/
 * Premium Question
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Tree
 * Algorithm - DFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun equalToDescendants(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    var result = 0
    fun getSum(current: TreeNode): Int {
        val left = current.left?.let {
            getSum(it)
        } ?: 0
        val right = current.right?.let {
            getSum(it)
        } ?: 0
        if (left + right == current.`val`) {
            result++
        }
        return left + right + current.`val`
    }
    getSum(root)
    return result
}

private fun main() {

}
