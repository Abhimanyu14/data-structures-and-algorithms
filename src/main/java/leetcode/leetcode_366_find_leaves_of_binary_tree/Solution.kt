package leetcode.leetcode_366_find_leaves_of_binary_tree

import data_structures_and_algorithms.TreeNode
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/find-leaves-of-binary-tree/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 173 ms, faster than 90.91%
 * Memory Usage: 34.3 MB, less than 90.91%
 */
private fun findLeaves(root: TreeNode?): List<List<Int>> {
    if (root == null) {
        return emptyList()
    }
    val nodes = mutableMapOf<Int, MutableList<Int>>()
    getLeaves(root, nodes)
    val result = mutableListOf<List<Int>>()
    for (i in 1..nodes.size) {
        nodes[i]?.let {
            result.add(it)
        }
    }
    return result
}

fun getLeaves(root: TreeNode, nodes: MutableMap<Int, MutableList<Int>>): Int {
    if (root.left == null && root.right == null) {
        nodes.computeIfAbsent(1) {
            mutableListOf()
        }.add(root.`val`)
        return 1
    }
    val left = if (root.left != null) {
        getLeaves(root.left!!, nodes)
    } else {
        0
    }
    val right = if (root.right != null) {
        getLeaves(root.right!!, nodes)
    } else {
        0
    }
    val depth = max(left, right) + 1
    nodes.computeIfAbsent(depth) {
        mutableListOf()
    }.add(root.`val`)
    return depth
}

private fun main() {

}
