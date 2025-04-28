package leetcode.leetcode_623_add_one_row_to_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/add-one-row-to-tree/?envType=daily-question&envId=2024-04-16
 *
 * Using recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 199 ms, faster than 9.09%
 * Memory Usage: 38.6 MB, less than 9.09%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
    if (root == null) {
        return null
    }
    if (depth == 1) {
        val head = TreeNode(`val`)
        head.left = root
        return head
    }
    fun dfs(current: TreeNode, currentDepth: Int) {
        // println("${current.`val`} ${currentDepth}")
        if (currentDepth < depth - 1) {
            current.left?.let {
                dfs(it, currentDepth + 1)
            }
            current.right?.let {
                dfs(it, currentDepth + 1)
            }
        } else if (currentDepth == depth - 1) {
            val leftNode = TreeNode(`val`)
            val rightNode = TreeNode(`val`)
            leftNode.left = current.left
            rightNode.right = current.right
            current.left = leftNode
            current.right = rightNode
        }
    }

    dfs(root, 1)

    return root
}

private fun main() {

}
