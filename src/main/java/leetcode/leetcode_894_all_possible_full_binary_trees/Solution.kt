package leetcode.leetcode_894_all_possible_full_binary_trees

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/all-possible-full-binary-trees/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 251 ms, faster than 61.90%
 * Memory Usage: 50.6 MB, less than 28.57%
 */
private fun allPossibleFBT(n: Int): List<TreeNode?> {
    if (n % 2 == 0) {
        return emptyList()
    }
    if (n == 1) {
        return listOf(TreeNode(0))
    }
    val result = mutableListOf<TreeNode>()
    var i = 1
    while (i < n) {
        val leftBTs = allPossibleFBT(i)
        val rightBTs = allPossibleFBT(n - 1 - i)
        leftBTs.forEach { left ->
            rightBTs.forEach { right ->
                result.add(
                    TreeNode(0).apply {
                        this.left = left
                        this.right = right
                    }
                )
            }
        }
        i += 2
    }
    return result
}

private fun main() {

}
