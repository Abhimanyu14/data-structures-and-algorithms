package leetcode.leetcode_236_lowest_common_ancestor_of_a_binary_tree

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Using
 *
 * Stats
 * Runtime: 431 ms, faster than 10.41%
 * Memory Usage: 223.6 MB, less than 5.43%
 */
private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    fun findNodePath(head: TreeNode?, target: TreeNode?, currentPath: String): String? {
        if (head?.`val` == target?.`val`) {
            return currentPath
        }
        if (head?.left == null && head?.right == null) {
            return null
        }
        findNodePath(head?.left, target, currentPath + "L")?.let {
            return it
        }
        findNodePath(head?.right, target, currentPath + "R")?.let {
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
