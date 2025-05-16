package leetcode.leetcode_2265_count_nodes_equal_to_average_of_subtree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Tree
 * Algorithm - DFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun averageOfSubtree(root: TreeNode?): Int {
    root ?: return 0
    var result = 0
    fun dfs(current: TreeNode): Pair<Int, Int> {
        val (leftSum, leftCount) = current.left?.run {
            dfs(this)
        } ?: Pair(0, 0)
        val (rightSum, rightCount) = current.right?.run {
            dfs(this)
        } ?: Pair(0, 0)
        if (((leftSum + rightSum + current.`val`) / (leftCount + rightCount + 1)) == current.`val`) {
            result++
        }
        return Pair((leftSum + rightSum + current.`val`), (leftCount + rightCount + 1))
    }

    dfs(root)
    return result
}

private fun main() {

}
