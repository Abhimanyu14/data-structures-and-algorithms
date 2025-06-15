package leetcode.leetcode_993_cousins_in_binary_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/cousins-in-binary-tree/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 *
 * Data Structure - Tree
 * Algorithm - DFS (Recursion)
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
    if (root == null || root.`val` == x || root.`val` == y) {
        return false
    }
    var parentX: Int? = null
    var parentY: Int? = null
    var depthX: Int? = null
    var depthY: Int? = null
    fun dfs(current: TreeNode, depth: Int, parent: Int) {
        if (current.`val` == x) {
            depthX = depth
            parentX = parent
        } else if (current.`val` == y) {
            depthY = depth
            parentY = parent
        }
        current.left?.let {
            dfs(it, depth + 1, current.`val`)
        }
        current.right?.let {
            dfs(it, depth + 1, current.`val`)
        }
    }
    root.left?.let {
        dfs(it, 1, root.`val`)
    }
    root.right?.let {
        dfs(it, 1, root.`val`)
    }
    return (depthX == depthY) && (parentX != parentY)
}

/**
 * leetcode - https://leetcode.com/problems/cousins-in-binary-tree/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 *
 * Data Structure - Tree, [ArrayDeque] (Queue)
 * Algorithm - BFS
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */

private fun isCousinsUsingBfs(root: TreeNode?, x: Int, y: Int): Boolean {
    if (root == null || root.`val` == x || root.`val` == y) {
        return false
    }
    var parentX: Int? = null
    var parentY: Int? = null
    var depthX: Int? = null
    var depthY: Int? = null
    val queue = ArrayDeque<Triple<TreeNode, Int, Int>>()
    root.left?.let {
        queue.addLast(Triple(it, 1, root.`val`))
    }
    root.right?.let {
        queue.addLast(Triple(it, 1, root.`val`))
    }
    while (queue.isNotEmpty() && (parentX == null || parentY == null)) {
        val (node, depth, parent) = queue.removeFirst()
        if (node.`val` == x) {
            depthX = depth
            parentX = parent
        } else if (node.`val` == y) {
            depthY = depth
            parentY = parent
        }
        node.left?.let {
            queue.addLast(Triple(it, depth + 1, node.`val`))
        }
        node.right?.let {
            queue.addLast(Triple(it, depth + 1, node.`val`))
        }
    }
    return (depthX == depthY) && (parentX != parentY)
}

private fun main() {

}
