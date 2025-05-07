package leetcode.leetcode_226_invert_binary_tree

import data_structures.TreeNode

/**
 * leetcode -  https://leetcode.com/problems/invert-binary-tree/
 *
 * Data Structure - Tree
 * Algorithm - Recursion
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N) - Recursion stack
 *
 * Companies - Google
 */
private fun invertTree(root: TreeNode?): TreeNode? {
    root?.left = invertTree(root?.right).also {
        root?.right = invertTree(root?.left)
    }
    return root
}

private fun main() {

}
