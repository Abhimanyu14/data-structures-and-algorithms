package leetcode.leetcode_572_subtree_of_another_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/subtree-of-another-tree/
 *
 * Data Structure - Tree
 * Algorithm - DFS
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
private fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (root == null || subRoot == null) {
        return false
    }
    fun isSameTree(tree1: TreeNode, tree2: TreeNode): Boolean {
        if (tree1.`val` != tree2.`val`) {
            return false
        }
        if (tree1.left == null && tree2.left == null) {
            if (tree1.right == null && tree2.right == null) {
                return true
            }
            if (tree1.right == null || tree2.right == null) {
                return false
            }
            return isSameTree(tree1.right!!, tree2.right!!)
        }
        if (tree1.left == null || tree2.left == null) {
            return false
        }
        if (tree1.right == null && tree2.right == null) {
            return isSameTree(tree1.left!!, tree2.left!!)
        }
        if (tree1.right == null || tree2.right == null) {
            return false
        }
        return isSameTree(tree1.left!!, tree2.left!!) && isSameTree(tree1.right!!, tree2.right!!)
    }

    fun dfs(current: TreeNode): Boolean {
        if (current.`val` == subRoot.`val` && isSameTree(current, subRoot)) {
            return true
        }
        return current.left?.let { dfs(it) } ?: false || current.right?.let { dfs(it) } ?: false
    }
    return dfs(root)
}

private fun main() {

}
