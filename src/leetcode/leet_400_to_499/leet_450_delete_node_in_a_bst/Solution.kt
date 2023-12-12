package leetcode.leet_400_to_499.leet_450_delete_node_in_a_bst

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/delete-node-in-a-bst/
 *
 * Using recursion
 * Note: Can delete max in left BST or min in right BST
 *
 * Stats
 * Runtime: 216 ms, faster than 75.53%
 * Memory Usage: 39.1 MB, less than 22.34%
 */
private fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
    if (root == null) {
        return null
    }
    fun findMax(node: TreeNode?): Int {
        var current = node
        while (current?.right != null) {
            current = current.right
        }
        return current?.`val` ?: 0
    }

    when {
        key < root.`val` -> {
            root.left = deleteNode(root.left, key)
        }

        key > root.`val` -> {
            root.right = deleteNode(root.right, key)
        }

        else -> {
            if (root.left == null) {
                return root.right
            } else if (root.right == null) {
                return root.left
            }

            root.`val` = findMax(root.left)
            root.left = deleteNode(root.left, root.`val`)
        }
    }
    return root
}

private fun main() {

}
