package leetcode.leet_600_to_699.leet_606_construct_string_from_binary_tree

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/construct-string-from-binary-tree
 *
 * Using recursion
 *
 * Stats
 * Runtime: 250 ms, faster than 9.09%
 * Memory Usage: 49.9 MB, less than 13.64%
 */
private fun tree2str(root: TreeNode?): String {
    val right = if (root?.right == null) {
        ""
    } else {
        "(${tree2str(root.right)})"
    }
    val left = if (root?.left == null) {
        if (right.isBlank()) {
            ""
        } else {
            "()"
        }
    } else {
        "(${tree2str(root.left)})"
    }
    return "${root?.`val` ?: 0}$left$right"
}

private fun main() {

}
