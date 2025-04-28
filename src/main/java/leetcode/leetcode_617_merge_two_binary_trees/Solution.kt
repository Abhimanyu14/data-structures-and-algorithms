package leetcode.leetcode_617_merge_two_binary_trees

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/merge-two-binary-trees/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 497 ms, faster than 30.43%
 * Memory Usage: 51.1 MB, less than 56.52%
 */
private fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null) {
        return root2
    }
    if (root2 == null) {
        return root1
    }
    return TreeNode(root1.`val` + root2.`val`).apply {
        left = mergeTrees(root1.left, root2.left)
        right = mergeTrees(root1.right, root2.right)
    }
}

private fun main() {

}
