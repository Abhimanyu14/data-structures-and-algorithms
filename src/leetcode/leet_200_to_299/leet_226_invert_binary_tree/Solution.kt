package leetcode.leet_200_to_299.leet_226_invert_binary_tree

import data_structures.data_structures.TreeNode

/**
 * Using recursion
 *
 * Stats
 * Runtime: 248 ms, faster than 50.13%
 * Memory Usage: 34.4 MB, less than 30.81%
 */
fun invertTree(root: TreeNode?): TreeNode? {
    root?.left = invertTree(root?.right).also {
        root?.right = invertTree(root?.left)
    }
    return root
}

private fun main() {

}
