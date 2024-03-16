package leetcode.leet_1100_to_1199.leet_1123_lowest_common_ancestor_of_deepest_leaves

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 180 ms, faster than 84.21%
 * Memory Usage: 38.3 MB, less than 31.58%
 */
private fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    fun findLca(head: TreeNode, depth: Int): Pair<TreeNode, Int> {
        if (head.left == null && head.right == null) {
            return Pair(head, depth)
        }
        val leftResult = head.left?.let {
            findLca(it, depth + 1)
        } ?: Pair(head, 0)
        val rightResult = head.right?.let {
            findLca(it, depth + 1)
        } ?: Pair(head, 0)
        return if (leftResult.second == rightResult.second) {
            Pair(head, leftResult.second)
        } else if (leftResult.second > rightResult.second) {
            leftResult
        } else {
            rightResult
        }
    }
    return findLca(root, 0).first
}

private fun main() {

}
