package leetcode.leetcode_270_closest_binary_search_tree_value

import data_structures_and_algorithms.TreeNode
import kotlin.math.abs
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/closest-binary-search-tree-value/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Tree
 * Algorithm - Tree traversal using Recursion
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 18.18%
 * Memory Usage: 37.04 MB, less than 94.52%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun closestValue(root: TreeNode?, target: Double): Int {
    if (root == null) {
        return 0
    }
    if (root.left == null && root.right == null) {
        return root.`val`
    }
    val left = root.left?.run {
        closestValue(root.left, target)
    } ?: Int.MAX_VALUE
    val right = root.right?.run {
        closestValue(root.right, target)
    } ?: Int.MAX_VALUE

    val rootDiff = abs(root.`val` - target)
    val leftDiff = abs(left - target)
    val rightDiff = abs(right - target)

    if (rootDiff < leftDiff && rootDiff < rightDiff) {
        return root.`val`
    } else if (rootDiff < leftDiff && rootDiff == rightDiff) {
        return min(root.`val`, right)
    } else if (rootDiff < leftDiff && rootDiff > rightDiff) {
        return right
    } else if (rootDiff == leftDiff && rootDiff < rightDiff) {
        return min(root.`val`, left)
    } else if (rootDiff == leftDiff && rootDiff == rightDiff) {
        return minOf(root.`val`, left, right)
    } else if (rootDiff == leftDiff && rootDiff > rightDiff) {
        return right
    } else if (rootDiff > leftDiff && rootDiff < rightDiff) {
        return left
    } else if (rootDiff > leftDiff && rootDiff == rightDiff) {
        return min(root.`val`, right)
    } else {
        return if (leftDiff < rightDiff) {
            left
        } else if (leftDiff == rightDiff) {
            min(left, right)
        } else {
            right
        }
    }
}

private fun main() {

}
