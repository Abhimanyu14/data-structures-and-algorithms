package leetcode.leetcode_230_kth_smallest_element_in_a_bst

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - BST
 * Algorithm - DFS - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun kthSmallest(root: TreeNode?, k: Int): Int {
    if (root == null) {
        return -1
    }
    fun kthSmallest(current: TreeNode, count: Int): Pair<Int?, Int> { // Result value, count
        val left = current.left?.let {
            kthSmallest(it, count)
        } ?: Pair(null, 0)
        if (left.first != null) {
            return left
        }
        if (left.second + count + 1 == k) {
            return Pair(current.`val`, 0)
        }
        val right = current.right?.let {
            kthSmallest(it, count + left.second + 1)
        } ?: Pair(null, 0)
        if (right.first != null) {
            return right
        }
        return Pair(null, left.second + right.second + 1)
    }
    return kthSmallest(root, 0).first ?: -1
}

private fun main() {

}
