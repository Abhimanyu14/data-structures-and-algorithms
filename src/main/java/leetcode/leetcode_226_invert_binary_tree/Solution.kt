package leetcode.leetcode_226_invert_binary_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/invert-binary-tree/
 * https://leetcode.com/problems/invert-binary-tree/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=EASY
 *
 * Algorithm - Recursion
 *
 * Stats
 * Runtime: 248 ms, faster than 50.13%
 * Memory Usage: 34.4 MB, less than 30.81%
 */
private fun invertTree(root: TreeNode?): TreeNode? {
    root?.left = invertTree(root?.right).also {
        root?.right = invertTree(root?.left)
    }
    return root
}

private fun main() {

}
