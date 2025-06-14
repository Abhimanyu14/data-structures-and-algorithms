package leetcode.leetcode_105_construct_binary_tree_from_preorder_and_inorder_traversal

import data_structures.TreeNode

/**
 * leetcode -
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) {
        return null
    }
    fun buildTree(preorderStart: Int, preorderEnd: Int, inorderStart: Int, inorderEnd: Int): TreeNode {
        val root = TreeNode(preorder[preorderStart])
        var moves = 0
        while (inorderStart + moves <= inorderEnd && inorder[inorderStart + moves] != preorder[preorderStart]) {
            moves++
        }
        if (inorderStart + moves <= inorderEnd && inorderStart + moves != inorderStart) {
            root.left = buildTree(preorderStart + 1, preorderStart + moves, inorderStart, inorderStart + moves - 1)
        }
        if (inorderStart + moves < inorderEnd) {
            root.right = buildTree(preorderStart + moves + 1, preorderEnd, inorderStart + moves + 1, inorderEnd)
        }
        return root
    }
    return buildTree(0, preorder.lastIndex, 0, inorder.lastIndex)
}

private fun main() {

}
