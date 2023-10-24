package leetcode.leet_500_to_599.leet_515_find_largest_value_in_each_tree_row

import data_structures_and_algorithms.TreeNode
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 214 ms, faster than 44.12%
 * Memory Usage: 37.9 MB, less than 55.88%
 */
private fun largestValues(root: TreeNode?): List<Int> {
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
