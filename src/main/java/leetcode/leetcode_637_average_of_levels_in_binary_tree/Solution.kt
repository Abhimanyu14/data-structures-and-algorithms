package leetcode.leetcode_637_average_of_levels_in_binary_tree

import data_structures_and_algorithms.TreeNode
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/average-of-levels-in-binary-tree/
 *
 * Using map and recursion
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 300 ms, faster than 22.05%
 * Memory Usage: 42 MB, less than 66.93%
 *
 * Time - O(N)
 * Space - O(N) - Implicit recursion stack
 */
private fun averageOfLevels(root: TreeNode?): DoubleArray {
    if (root == null) {
        return doubleArrayOf()
    }
    val map = mutableMapOf<Int, Pair<Double, Int>>() // <Depth, <Sum, Count>>
    var maxDepth = 0

    fun dfs(head: TreeNode, currentDepth: Int) {
        maxDepth = max(maxDepth, currentDepth)
        map.getOrDefault(currentDepth, Pair(0.0, 0)).let { (sum, count) ->
            map[currentDepth] = Pair(sum + head.`val`, count + 1)
        }
        head.left?.let {
            dfs(it, currentDepth + 1)
        }
        head.right?.let {
            dfs(it, currentDepth + 1)
        }
    }
    dfs(root, 0)

    val result = DoubleArray(maxDepth + 1)
    repeat(maxDepth + 1) {
        map.getOrDefault(it, Pair(0.0, 0)).let { (sum, count) ->
            result[it] = sum / count
        }
    }
    return result
}

private fun main() {

}
