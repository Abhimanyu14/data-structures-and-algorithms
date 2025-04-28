package leetcode.leetcode_530_minimum_absolute_difference_in_bst

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 *
 * Using BST inorder traversal and loop
 *
 * Stats
 * Runtime: 402 ms, faster than 60.71%
 * Memory Usage: 44.7 MB, less than 50.00%
 *
 */
private fun getMinimumDifference(root: TreeNode?): Int {
    val list = mutableListOf<Int>()
    bstInorderTraversal(root, list)
    var min = Int.MAX_VALUE
    for (i in 0..<list.lastIndex) {
        if (list[i + 1] - list[i] < min) {
            min = list[i + 1] - list[i]
        }
    }

    return min
}

private fun bstInorderTraversal(root: TreeNode?, list: MutableList<Int>) {
    root?.left?.let {
        bstInorderTraversal(it, list)
    }
    root?.`val`?.let {
        list.add(it)
    }
    root?.right?.let {
        bstInorderTraversal(it, list)
    }
}

private fun main() {

}
