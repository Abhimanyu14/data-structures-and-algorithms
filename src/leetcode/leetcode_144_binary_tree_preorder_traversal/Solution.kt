package leetcode.leetcode_144_binary_tree_preorder_traversal

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * Using Morris Traversal
 *
 * Stats
 * Runtime: 164 ms, faster than 91.38%
 * Memory Usage: 34.3 MB, less than 74.71%
 */
private fun preorderTraversal(root: TreeNode?): List<Int> {
    val result: MutableList<Int> = ArrayList()
    var current = root
    var last: TreeNode?
    while (current != null) {
        if (current.left == null) {
            result.add(current.`val`)
            current = current.right
        } else {
            last = current.left
            while (last?.right != null && last.right != current) {
                last = last.right
            }
            if (last?.right == null) {
                result.add(current.`val`)
                last?.right = current
                current = current.left
            } else {
                last.right = null
                current = current.right
            }
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * Using stack
 *
 * Stats
 * Runtime: 170 ms, faster than 82.76%
 * Memory Usage: 34.3 MB, less than 68.97%
 */
private fun preorderTraversalUsingStack(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = ArrayDeque<TreeNode>()
    var ele: TreeNode
    root?.let {
        stack.addLast(it)
    }
    while (stack.isNotEmpty()) {
        ele = stack.removeLast()
        result.add(ele.`val`)
        ele.right?.let {
            stack.addLast(it)
        }
        ele.left?.let {
            stack.addLast(it)
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 184 ms, faster than 68.97%
 * Memory Usage: 36.2 MB, less than 6.90%
 */
private fun preorderTraversalUsingRecursion(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }
    val list = mutableListOf<Int>()
    fun parseTree(root: TreeNode, list: MutableList<Int>) {
        list.add(root.`val`)
        root.left?.let {
            parseTree(it, list)
        }
        root.right?.let {
            parseTree(it, list)
        }
    }
    parseTree(root, list)
    return list
}

private fun main() {

}

