package leetcode.leetcode_113_path_sum_ii

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/path-sum-ii/description/
 *
 * Data Structure - Tree
 * Algorithm - Backtracking - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    if (root == null) {
        return emptyList()
    }
    val result = mutableListOf<List<Int>>()
    fun getPathSum(current: TreeNode, nodesSoFar: MutableList<Int>, sumSoFar: Int) {
        if (current.left == null && current.right == null) {
            if (sumSoFar + current.`val` == targetSum) {
                nodesSoFar.add(current.`val`)
                result.add(nodesSoFar.toList())
                nodesSoFar.removeLast()
            }
            return
        }
        current.left?.let {
            nodesSoFar.add(current.`val`)
            getPathSum(it, nodesSoFar, sumSoFar + current.`val`)
            nodesSoFar.removeLast()
        }
        current.right?.let {
            nodesSoFar.add(current.`val`)
            getPathSum(it, nodesSoFar, sumSoFar + current.`val`)
            nodesSoFar.removeLast()
        }
    }
    getPathSum(root, mutableListOf(), 0)
    return result
}

private fun main() {

}
