package leetcode.leetcode_671_second_minimum_node_in_a_binary_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun findSecondMinimumValue(root: TreeNode?): Int {
    if (root == null) {
        return -1
    }

    fun dfs(current: TreeNode): Pair<Int, Int> {
        if (current.left == null) {
            return Pair(current.`val`, current.`val`)
        }
        val (leftMinValue, leftSecondMin) = dfs(current.left!!)
        val (rightMinValue, rightSecondMin) = dfs(current.right!!)
        val sortedSet = setOf(leftMinValue, leftSecondMin, rightMinValue, rightSecondMin).sorted()
        if (sortedSet.size == 1) {
            return Pair(sortedSet.first(), sortedSet.first())
        }
        return Pair(sortedSet[0], sortedSet[1])
    }
    val (minValue, secondMin) = dfs(root)
    if (minValue == secondMin) {
        return -1
    }
    return secondMin
}

private fun main() {

}
