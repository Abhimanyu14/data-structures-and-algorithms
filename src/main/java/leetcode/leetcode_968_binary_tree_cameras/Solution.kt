package leetcode.leetcode_968_binary_tree_cameras

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/binary-tree-cameras/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Set]
 * Algorithm - DFS
 *
 * Source - https://youtu.be/2Gh5WPjAgJk
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private enum class State {
    NOT_MONITORED,
    MONITORED,
    HAS_CAMERA,
}

private fun minCameraCover(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    var result = 0
    fun dfs(current: TreeNode): State {
        val left = current.left?.let {
            dfs(it)
        } ?: State.MONITORED
        val right = current.right?.let {
            dfs(it)
        } ?: State.MONITORED
        if (left == State.NOT_MONITORED || right == State.NOT_MONITORED) {
            result++
            return State.HAS_CAMERA
        }
        if (left == State.HAS_CAMERA || right == State.HAS_CAMERA) {
            return State.MONITORED
        }
        return State.NOT_MONITORED
    }
    if (dfs(root) == State.NOT_MONITORED) {
        result++
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/binary-tree-cameras/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Set]
 * Algorithm - DFS
 *
 * Source - https://youtu.be/2Gh5WPjAgJk
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun minCameraCoverUsingSet(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    var result = 0
    val monitoredNodes = mutableSetOf<TreeNode>()
    fun dfs(current: TreeNode, parent: TreeNode?) {
        current.left?.let {
            dfs(it, current)
        }
        current.right?.let {
            dfs(it, current)
        }
        if (
            (parent == null && !monitoredNodes.contains(current)) ||
            (current.left != null && !monitoredNodes.contains(current.left)) ||
            (current.right != null && !monitoredNodes.contains(current.right))
        ) {
            result++
            monitoredNodes.add(current)
            parent?.let {
                monitoredNodes.add(it)
            }
            current.left?.let {
                monitoredNodes.add(it)
            }
            current.right?.let {
                monitoredNodes.add(it)
            }
        }
    }
    dfs(root, null)
    return result
}

private fun main() {

}
