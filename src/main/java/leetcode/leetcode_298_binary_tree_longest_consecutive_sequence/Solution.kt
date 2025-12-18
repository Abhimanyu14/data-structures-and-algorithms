package leetcode.leetcode_298_binary_tree_longest_consecutive_sequence

import data_structures.TreeNode
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/?envType=weekly-question&envId=2025-12-15
 *
 * Data Structure - Trees
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Google
 */
private fun longestConsecutive(root: TreeNode?): Int {
    var result = 0
    fun calculateLongestLength(current: TreeNode?): Int {
        if (current == null) {
            return 0
        }
        val leftLength = calculateLongestLength(current.left)
        val rightLength = calculateLongestLength(current.right)
        var currentLength = 1
        if (current.left?.`val` == (current.`val` + 1)) {
            currentLength = max(currentLength, leftLength + 1)
        }
        if (current.right?.`val` == (current.`val` + 1)) {
            currentLength = max(currentLength, rightLength + 1)
        }
        result = max(result, currentLength)
        return currentLength
    }
    calculateLongestLength(root)
    return result
}
