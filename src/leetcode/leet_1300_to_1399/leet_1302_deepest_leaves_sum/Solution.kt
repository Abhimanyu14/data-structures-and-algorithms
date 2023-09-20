package leetcode.leet_1300_to_1399.leet_1302_deepest_leaves_sum

import data_structures_and_algorithms.TreeNode
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/deepest-leaves-sum/
 * Using DFS
 *
 * Stats
 * Runtime: 595 ms, faster than 58.70%
 * Memory Usage: 67.4 MB, less than 63.04%
 */
private fun deepestLeavesSuUsingDFS(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    fun findDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return 1 + max(findDepth(root.left), findDepth(root.right))
    }

    fun findDeepestLeavesSum(root: TreeNode?, depth: Int, currentDepth: Int): Int {
        if (root == null) {
            return 0
        }
        if (depth == currentDepth) {
            return root.`val`
        }
        return findDeepestLeavesSum(root.left, depth, currentDepth + 1) +
                findDeepestLeavesSum(root.right, depth, currentDepth + 1)
    }

    val depth = findDepth(root)
    return findDeepestLeavesSum(root, depth, 1)
}

/**
 * leetcode - https://leetcode.com/problems/deepest-leaves-sum/
 * Using BFS
 *
 * Stats
 * Runtime: 648 ms, faster than 37.50%
 * Memory Usage: 70.7 MB, less than 37.50%
 */
private fun deepestLeavesSum(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val nextLevel = ArrayDeque<TreeNode>()
    val currentLevel = ArrayDeque<TreeNode>()
    nextLevel.addFirst(root)

    while (!nextLevel.isEmpty()) {
        currentLevel.clear()
        currentLevel.addAll(nextLevel)
        nextLevel.clear()
        for (node in currentLevel) {
            node.left?.let {
                nextLevel.addFirst(it)
            }
            node.right?.let {
                nextLevel.addFirst(it)
            }
        }
    }
    var deepestSum = 0
    for (node in currentLevel) {
        deepestSum += node.`val`
    }
    return deepestSum
}

private fun main() {

}
