package leetcode.leetcode_337_house_robber_iii

import data_structures.TreeNode
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/house-robber-iii/
 *
 * Using DFS
 *
 * Stats
 * Runtime: 155 ms, faster than 100.00%
 * Memory Usage: 37.8 MB, less than 45.45%
 */
private fun rob(root: TreeNode?): Int {
    fun dfs(head: TreeNode?): Pair<Int, Int> { // with head, without head
        if (head == null) {
            return Pair(0, 0)
        }
        val left = dfs(head.left)
        val right = dfs(head.right)
        return Pair(
            head.`val` + left.second + right.second,
            max(left.first, left.second) + max(right.first, right.second),
        )
    }
    val result = dfs(root)
    return max(result.first, result.second)
}

/**
 * leetcode - https://leetcode.com/problems/house-robber-iii/
 *
 * Using recursion, dynamic programming
 *
 * Stats
 * Runtime: 201 ms, faster than 27.27%
 * Memory Usage: 42.1 MB, less than 9.09%
 */
private fun robRecursion(root: TreeNode?): Int {
    val dp = mutableMapOf<Pair<TreeNode?, Boolean>, Int>()
    fun process(head: TreeNode?, parentAdded: Boolean): Int {
        if (head == null) {
            return 0
        }
        dp[Pair(head, parentAdded)]?.let {
            return it
        }
        dp[Pair(head, parentAdded)] = if (parentAdded) {
            process(head.left, false) + process(head.right, false)
        } else {
            max(
                process(head.left, false) + process(head.right, false),
                head.`val` + process(head.left, true) + process(head.right, true),
            )
        }
        return dp[Pair(head, parentAdded)] ?: 0
    }
    return process(root, false)
}

private fun main() {

}
