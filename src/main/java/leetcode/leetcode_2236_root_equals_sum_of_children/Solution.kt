package leetcode.leetcode_2236_root_equals_sum_of_children

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/root-equals-sum-of-children/
 *
 * Using addition
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34.4 MB, less than 17.39%
 *
 * Time - O(1)
 * Space - NA
 */
private fun checkTree(root: TreeNode?): Boolean {
    return (root?.`val` ?: 0) == ((root?.left?.`val` ?: 0) + (root?.right?.`val` ?: 0))
}

private fun main() {

}
