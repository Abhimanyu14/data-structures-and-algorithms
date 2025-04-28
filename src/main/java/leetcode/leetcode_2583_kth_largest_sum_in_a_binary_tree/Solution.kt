package leetcode.leetcode_2583_kth_largest_sum_in_a_binary_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/?envType=daily-question&envId=2024-10-22
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 86 ms, faster than 100.00%
 * Memory Usage: 219.8 MB, less than 11.11%
 *
 * Time -
 * Space -
 */
private fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
    if (root == null) {
        return -1L
    }
    val sumMap = mutableMapOf<Int, Long>()
    fun levelSum(node: TreeNode, level: Int) {
        sumMap[level] = sumMap.getOrDefault(level, 0) + node.`val`.toLong()
        node.left?.let {
            levelSum(it, level + 1)
        }
        node.right?.let {
            levelSum(it, level + 1)
        }
    }
    levelSum(root, 1)
    return if (sumMap.values.size < k) {
        -1L
    } else {
        sumMap.values.sortedDescending()[k - 1]
    }
}

private fun main() {

}
