package leetcode.leetcode_236_lowest_common_ancestor_of_a_binary_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 431 ms, faster than 10.41%
 * Memory Usage: 223.6 MB, less than 5.43%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || p == null || q == null) {
        return null
    }
    fun find(current: TreeNode): Triple<Boolean, Boolean, TreeNode?> {
        val left = current.left?.let {
            find(it)
        } ?: Triple(false, false, null)
        if (left.third != null) {
            return left
        }
        val right = current.right?.let {
            find(it)
        } ?: Triple(false, false, null)
        if (right.third != null) {
            return right
        }
        val foundP = current == p || left.first || right.first
        val foundQ = current == q || left.second || right.second
        return if (foundP && foundQ) {
            Triple(true, true, current)
        } else if (foundP) {
            Triple(true, false, null)
        } else if (foundQ) {
            Triple(false, true, null)
        } else {
            Triple(false, false, null)
        }
    }
    return find(root).third
}

private fun findNodePath(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    fun findNodePath(head: TreeNode?, target: TreeNode?, currentPath: String): String? {
        if (head?.`val` == target?.`val`) {
            return currentPath
        }
        if (head?.left == null && head?.right == null) {
            return null
        }
        findNodePath(head.left, target, currentPath + "L")?.let {
            return it
        }
        findNodePath(head.right, target, currentPath + "R")?.let {
            return it
        }
        return null
    }

    val pPath = findNodePath(root, p, "")
    val qPath = findNodePath(root, q, "")
    if (pPath == null || qPath == null || pPath == "" || qPath == "") {
        return root
    }

    var current = root
    var index = 0
    while (index < pPath.length && index < qPath.length) {
        current = if (pPath[index] == qPath[index]) {
            if (pPath[index] == 'L') {
                current?.left
            } else {
                current?.right
            }
        } else {
            return current
        }
        index++
    }
    return current
}

private fun main() {

}
