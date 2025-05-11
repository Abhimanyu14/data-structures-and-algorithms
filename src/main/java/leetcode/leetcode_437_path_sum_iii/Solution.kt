package leetcode.leetcode_437_path_sum_iii

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/path-sum-iii/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Tree
 * Algorithm - Recursion, Prefix Sum
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun pathSum(root: TreeNode?, targetSum: Int): Int {
    if (root == null) {
        return 0
    }
    var result = 0
    fun getCount(current: TreeNode, map: MutableMap<Long, Int>, pathSum: Long) {
        if (pathSum + current.`val` == targetSum.toLong()) {
            result++
        }
        result += map.getOrDefault(pathSum + current.`val` - targetSum, 0)
        map[pathSum + current.`val`] = map.getOrDefault(pathSum + current.`val`, 0) + 1
        current.left?.let {
            getCount(it, map, pathSum + current.`val`)
        }
        current.right?.let {
            getCount(it, map, pathSum + current.`val`)
        }
        map[pathSum + current.`val`] = map.getOrDefault(pathSum + current.`val`, 0) - 1
    }
    getCount(root, mutableMapOf(), 0)
    return result
}

private fun main() {

}
