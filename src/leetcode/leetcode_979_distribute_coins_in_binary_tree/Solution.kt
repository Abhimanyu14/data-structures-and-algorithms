package leetcode.leetcode_979_distribute_coins_in_binary_tree

import data_structures_and_algorithms.TreeNode
import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/distribute-coins-in-binary-tree/?envType=daily-question&envId=2024-05-18
 *
 * Using recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 170 ms, faster than 14.29%
 * Memory Usage: 35.9 MB, less than 14.29%
 *
 * Time -
 * Space -
 */
private fun distributeCoins(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    fun dfs(head: TreeNode): Pair<Int, Int> { // Pair(coinsRequired, moves)
        val left = head.left?.run { dfs(this) } ?: Pair(0, 0)
        val right = head.right?.run { dfs(this) } ?: Pair(0, 0)
        return Pair(
            1 + left.first + right.first - head.`val`,
            abs(left.first) + abs(right.first) + left.second + right.second,
        )
    }
    return dfs(root).second
}

private fun main() {

}
