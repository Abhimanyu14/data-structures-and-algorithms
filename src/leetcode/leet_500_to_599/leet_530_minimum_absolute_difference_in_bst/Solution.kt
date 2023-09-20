package leetcode.leet_500_to_599.leet_530_minimum_absolute_difference_in_bst

import data_structures_and_algorithms.TreeNode

/**
 * Using BST inorder traversal and loop
 *
 * Stats
 * Runtime: 402 ms, faster than 60.71%
 * Memory Usage: 44.7 MB, less than 50.00%
 *
 */
fun getMinimumDifference(root: TreeNode?): Int {
    val list = mutableListOf<Int>()
    bstInorderTraversal(root, list)
    var min = Int.MAX_VALUE
    for (i in 0 until list.lastIndex) {
        if (list[i + 1] - list[i] < min) {
            min = list[i + 1] - list[i]
        }
    }

    return min
}

fun bstInorderTraversal(root: TreeNode?, list: MutableList<Int>) {
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
