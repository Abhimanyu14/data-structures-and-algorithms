package leetcode.leet_100_to_199.leet_112_path_sum

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/path-sum/
 *
 * Using DFS - Recursion
 *
 * Stats
 * Runtime: 202 ms, faster than 85.85%
 * Memory Usage: 35.4 MB, less than 90.73%
 */
private fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    return dfs(root, 0, targetSum)
}

private fun dfs(root: TreeNode?, currentSum: Int, targetSum: Int): Boolean {
    if (root == null) {
        return false
    }
    if (root?.left == null && root?.right == null) {
        if (currentSum + (root?.`val` ?: 0) == targetSum) {
            return true
        }
        return false
    }
    return dfs(root?.left, currentSum + (root?.`val` ?: 0), targetSum) || dfs(
        root?.right,
        currentSum + (root?.`val` ?: 0),
        targetSum
    )
}

private fun main() {

}
