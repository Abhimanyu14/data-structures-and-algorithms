package leetcode.leetcode_129_sum_root_to_leaf_numbers

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/sum-root-to-leaf-numbers/?envType=daily-question&envId=2024-04-15
 *
 * Data Structure - Tree
 * Algorithm - DFS (Recursion)
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N) - Recursion stack
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun sumNumbers(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    var result = 0
    fun dfs(current: TreeNode, parent: Int) {
        if (current.left == null && current.right == null) {
            result += (parent * 10) + current.`val`
            return
        }
        current.left?.let {
            dfs(it, (parent * 10) + current.`val`)
        }
        current.right?.let {
            dfs(it, (parent * 10) + current.`val`)
        }
    }
    dfs(root, 0)
    return result
}

private fun main() {

}
