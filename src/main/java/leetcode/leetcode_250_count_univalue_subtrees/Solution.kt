package leetcode.leetcode_250_count_univalue_subtrees

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/count-univalue-subtrees/
 * Premium Question
 *
 * Data Structure - Tree
 * Algorithm - DFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * H: Height of Tree
 * Time - O(N)
 * Space - O(H)
 *
 * Companies - Amazon, Google
 */
private fun countUnivalSubtrees(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    fun countUnivalSubtrees(current: TreeNode): Pair<Int, Int?> {
        if (current.left == null && current.right == null) {
            return Pair(1, current.`val`)
        }
        val left = current.left?.let {
            countUnivalSubtrees(it)
        } ?: Pair(0, null)
        val right = current.right?.let {
            countUnivalSubtrees(it)
        } ?: Pair(0, null)
        return if (current.left == null && current.`val` != right.second) {
            Pair(right.first, null)
        } else if (current.right == null && current.`val` != left.second) {
            Pair(left.first, null)
        } else if (current.left != null && current.right != null && (current.`val` != left.second || current.`val` != right.second)) {
            Pair(left.first + right.first, null)
        } else {
            Pair(left.first + right.first + 1, current.`val`)
        }
    }
    return countUnivalSubtrees(root).first
}

private fun main() {

}
