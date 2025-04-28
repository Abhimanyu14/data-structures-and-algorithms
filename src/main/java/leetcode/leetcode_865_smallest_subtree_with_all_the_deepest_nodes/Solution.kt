package leetcode.leetcode_865_smallest_subtree_with_all_the_deepest_nodes

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * Data Structure - Tree
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 41.87 MB, less than 37.50%
 *
 * Time - O(N)
 * Space - O(N) - Recursion Stack
 *
 * Companies - Meta, Salesforce
 */
private fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    fun getMaxDepthAndItsRoot(current: TreeNode, depth: Int): Pair<TreeNode, Int> {
        val left = current.left?.let {
            getMaxDepthAndItsRoot(it, depth + 1)
        } ?: Pair(current, depth)
        val right = current.right?.let {
            getMaxDepthAndItsRoot(it, depth + 1)
        } ?: Pair(current, depth)
        return if (left.second == right.second) {
            Pair(current, left.second)
        } else if (left.second > right.second) {
            left
        } else {
            right
        }
    }
    return getMaxDepthAndItsRoot(root, 0).first
}

private fun main() {

}
