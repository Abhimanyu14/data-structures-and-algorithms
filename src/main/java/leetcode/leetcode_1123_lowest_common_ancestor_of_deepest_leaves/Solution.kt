package leetcode.leetcode_1123_lowest_common_ancestor_of_deepest_leaves

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 *
 * Data Structure - [Tree]
 * Algorithm - DFS (Recursion)
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 1 ms, faster than 75.00%
 * Memory Usage: 45.29 MB, less than 30.00%
 *
 * Time - O(N)
 * Space - O(N) - implicit stack
 *
 * Companies - Amazon, Meta
 */
private fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    fun dfs(current: TreeNode, depth: Int): Pair<TreeNode, Int> {
        val left = current.left?.let {
            dfs(it, depth + 1)
        } ?: Pair(current, depth)
        val right = current.right?.let {
            dfs(it, depth + 1)
        } ?: Pair(current, depth)
        return if (left.second == right.second) {
            Pair(current, left.second)
        } else if (left.second > right.second) {
            left
        } else {
            right
        }
    }
    return dfs(root, 0).first
}

private fun main() {

}
