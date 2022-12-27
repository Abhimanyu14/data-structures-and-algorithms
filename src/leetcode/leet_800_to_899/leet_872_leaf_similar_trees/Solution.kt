package leetcode.leet_800_to_899.leet_872_leaf_similar_trees

import data_structures.data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/leaf-similar-trees/
 *
 * Using DFS implemented with stack
 *
 * Stats
 * Runtime: 244 ms, faster than 75.00%
 * Memory Usage: 35.2 MB, less than 25.00%
 */
private fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    if (root1 == null || root2 == null) {
        return false
    }
    fun getLeaves(root: TreeNode): List<Int> {
        val stack = ArrayDeque<TreeNode>()
        val list = mutableListOf<Int>()
        stack.addLast(root)
        while (stack.isNotEmpty()) {
            val last = stack.removeLast()
            if (last.left == null && last.right == null) {
                list.add(last.`val`)
            } else {
                last.left?.let {
                    stack.addLast(it)
                }
                last.right?.let {
                    stack.addLast(it)
                }
            }
        }
        return list
    }
    return getLeaves(root1) == getLeaves(root2)
}

private fun main() {

}
