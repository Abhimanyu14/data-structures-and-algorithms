package leetcode.leet_100_to_199.leet_129_sum_root_to_leaf_numbers

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/sum-root-to-leaf-numbers/?envType=daily-question&envId=2024-04-15
 *
 * Using recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 140 ms, faster than 70.64%
 * Memory Usage: 34 MB, less than 53.21%
 *
 * Time - O(N)
 * Space - O(N) - recursion stack
 */
private fun sumNumbers(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    var result = 0

    fun sum (head: TreeNode, current: Int) {
        if (head.left == null && head.right == null) {
            result += (current * 10) + head.`val`
        }
        head.left?.let {
            sum(it, (current * 10) + head.`val`)
        }
        head.right?.let {
            sum(it, (current * 10) + head.`val`)
        }
    }
    sum(root, 0)
    return result
}

private fun main() {

}
