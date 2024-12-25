package leetcode.leetcode_1161_maximum_level_sum_of_a_binary_tree

import data_structures_and_algorithms.TreeNode
import java.util.LinkedList

/**
 * leetcode - https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 *
 * Data Structure - Tree
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 10 ms, faster than 89.34%
 * Memory Usage: 43.8 MB, less than 66.39%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun maxLevelSum(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    var result = 0
    val queue = LinkedList<TreeNode>()
    var level = 0
    var maxLevelSum = Int.MIN_VALUE
    queue.offer(root)
    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        level++
        var currentLevelSum = 0
        for (i in 0..<levelSize) {
            val current = queue.poll()
            currentLevelSum += current.`val`
            current.left?.let {
                queue.offer(it)
            }
            current.right?.let {
                queue.offer(it)
            }
        }
        if (currentLevelSum > maxLevelSum) {
            maxLevelSum = currentLevelSum
            result = level
        }
    }
    return result
}

private fun main() {

}
