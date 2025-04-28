package leetcode.leetcode_2415_reverse_odd_levels_of_binary_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/?envType=daily-question&envId=2024-12-20
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Tree
 * Algorithm - DFS
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 45.1 MB, less than 27.27%
 *
 * Time -
 * Space -
 */
private fun reverseOddLevels(root: TreeNode?): TreeNode? {
    fun traverseDFS(
        left: TreeNode,
        right: TreeNode,
        isEvenLevel: Boolean,
    ) {
        // If the current level is even, swap the values of the children.
        if (isEvenLevel) {
            left.`val` = right.`val`.also {
                right.`val` = left.`val`
            }
        }
        if (left.left != null && left.right != null && right.left != null && right.right != null) {
            traverseDFS(left.left!!, right.right!!, !isEvenLevel)
            traverseDFS(left.right!!, right.left!!, !isEvenLevel)
        }
    }
    if (root?.left != null && root.right != null) {
        traverseDFS(root.left!!, root.right!!, true)
    }
    return root
}

private fun main() {

}
