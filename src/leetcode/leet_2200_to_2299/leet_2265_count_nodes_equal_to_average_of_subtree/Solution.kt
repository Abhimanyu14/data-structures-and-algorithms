package leetcode.leet_2200_to_2299.leet_2265_count_nodes_equal_to_average_of_subtree

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 167 ms, faster than 66.67%
 * Memory Usage: 37.6 MB, less than 41.67%
 */
private fun averageOfSubtree(root: TreeNode?): Int {
    root ?: return 0
    var result = 0
    fun dfs(head: TreeNode): Pair<Int, Int> {
        val (leftSum, leftCount) = head.left?.run {
            dfs(this)
        } ?: Pair(0, 0)
        val (rightSum, rightCount) = head.right?.run {
            dfs(this)
        } ?: Pair(0, 0)
        if (((leftSum + rightSum + head.`val`) / (leftCount + rightCount + 1)) == head.`val`) {
            result++
        }
        return Pair((leftSum + rightSum + head.`val`), (leftCount + rightCount + 1))
    }

    dfs(root)
    return result
}

private fun main() {

}
