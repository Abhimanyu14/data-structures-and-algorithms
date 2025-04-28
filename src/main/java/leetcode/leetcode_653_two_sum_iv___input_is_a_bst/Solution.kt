package leetcode.leetcode_653_two_sum_iv___input_is_a_bst

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
 * Using set
 *
 * Stats
 * Runtime: 570 ms, faster than 14.28%
 * Memory Usage: 51.5 MB, less than 66.67%
 */
private fun findTarget(root: TreeNode?, k: Int): Boolean {
    val set = mutableSetOf<Int>()

    fun dfs(root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }
        if (set.contains(root?.`val` ?: 0)) {
            return true
        }
        set.add(k - (root?.`val` ?: 0))
        return dfs(root?.left) || dfs(root?.right)
    }
    return dfs(root)
}

private fun main() {

}
