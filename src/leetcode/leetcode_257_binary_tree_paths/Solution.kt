package leetcode.leetcode_257_binary_tree_paths

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/binary-tree-paths/
 *
 * Using recursion
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 173 ms, faster than 80.61%
 * Memory Usage: 34.9 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun binaryTreePaths(root: TreeNode?): List<String> {
    if (root == null) {
        return emptyList()
    }
    val result = mutableListOf<String>()
    fun parseTree(head: TreeNode, current: String) {
        if (head.left == null && head.right == null) {
            result.add(current)
        }
        head.left?.let {
            parseTree(it, "$current->${it.`val`}")
        }
        head.right?.let {
            parseTree(it, "$current->${it.`val`}")
        }
    }
    parseTree(root, "${root.`val`}")
    return result
}

private fun main() {

}
