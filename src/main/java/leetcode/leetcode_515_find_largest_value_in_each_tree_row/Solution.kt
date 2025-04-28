package leetcode.leetcode_515_find_largest_value_in_each_tree_row

import data_structures.TreeNode
import java.util.LinkedList
import kotlin.math.max


/**
 * leetcode - https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 *
 * Data Structure - Tree
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 9 ms, faster than 37.21%
 * Memory Usage: 39.7 MB, less than 18.60%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun largestValues(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }
    val result = mutableListOf<Int>()
    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    while (queue.isNotEmpty()) {
        val size = queue.size
        var currentMax = Int.MIN_VALUE
        for (i in 0..<size) {
            val current = queue.poll()
            currentMax = max(currentMax, current.`val`)
            current.left?.let {
                queue.offer(it)
            }
            current.right?.let {
                queue.offer(it)
            }
        }
        result.add(currentMax)
    }
    return result
}

/**
 * Runtime: 214 ms, faster than 44.12%
 * Memory Usage: 37.9 MB, less than 55.88%
 */
private fun largestValuesUsingDfs(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    fun dfs(head: TreeNode?, index: Int) {
        if (head == null) {
            return
        }
        if (result.size < index + 1) {
            result.add(head.`val`)
        } else {
            result[index] = max(result[index], head.`val`)
        }
        dfs(head.left, index + 1)
        dfs(head.right, index + 1)
    }
    dfs(root, 0)
    return result
}

private fun main() {

}
