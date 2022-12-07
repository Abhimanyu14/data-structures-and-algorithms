package leetcode.leet_100_to_199.leet_100_same_tree

import data_structures.data_structures.TreeNode

/**
 * Using recursion
 *
 * Stats
 * Runtime: 159 ms, faster than 90.65%
 * Memory Usage: 33.3 MB, less than 98.87%
 */
fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) {
        return true
    }
    return (p?.`val` == q?.`val`) && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
}

private fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null) {
        return root2
    }
    if (root2 == null) {
        return root1
    }
    val result = TreeNode(root1.`val` + root2.`val`).apply {
        left = merge(root1.left, root2.left)
        right = merge(root1.right, root2.right)
    }
    return result
}

private fun merge(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null) {
        return root2
    }
    if (root2 == null) {
        return root1
    }
    return TreeNode(root1.`val` + root2.`val`).apply {
        left = merge(root1.left, root2.left)
        right = merge(root1.right, root2.right)
    }
}

private fun main() {

}
