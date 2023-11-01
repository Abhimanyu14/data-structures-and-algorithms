package leetcode.leet_500_to_599.leet_501_find_mode_in_binary_search_tree

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/find-mode-in-binary-search-tree/
 *
 * Using map - counter
 *
 * Stats
 * Runtime: 249 ms, faster than 40.74%
 * Memory Usage: 41.3 MB, less than 11.11%
 */
private fun findMode(root: TreeNode?): IntArray {
    val counter = mutableMapOf<Int, Int>()
    fun dfs(head: TreeNode?) {
        if (head == null) {
            return
        }
        counter[head.`val`] = counter.getOrDefault(head.`val`, 0) + 1
        dfs(head.left)
        dfs(head.right)
    }

    dfs(root)
    val result = mutableListOf<Int>()
    var max = Int.MIN_VALUE
    counter.forEach { (key, value) ->
        if (value > max) {
            max = value
            result.clear()
            result.add(key)
        } else if (value == max) {
            result.add(key)
        }
    }
    return result.toIntArray()
}

private fun main() {

}
