package leetcode.leet_100_to_199.leet_114_flatten_binary_tree_to_linked_list

import data_structures_and_algorithms.TreeNode

/**
 * Using pointers and loops
 *
 * Stats
 * Runtime: 278 ms, faster than 85.71%
 * Memory Usage: 35.9 MB, less than 28.57%
 */
private fun flattenNaive(root: TreeNode?): Unit {
    fun flattenToList(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        var flattenedLeft = flattenToList(root.left)
        val flattenedRight = flattenToList(root.right)
        root.left = null
        if (flattenedLeft != null) {
            root.right = flattenedLeft
            while (flattenedLeft?.right != null) {
                flattenedLeft = flattenedLeft.right
            }
            flattenedLeft?.right = flattenedRight
        } else {
            root.right = flattenedRight
        }
        return root
    }

    flattenToList(root)
}

/**
 * Using recursion
 *
 * Stats
 * Runtime: 356 ms, faster than 11.43%
 * Memory Usage: 36.2 MB, less than 11.43%
 */
private fun flattenRecursion(root: TreeNode?): Unit {
    fun flattenToList(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val leftTail = flattenToList(root.left)
        val rightTail = flattenToList(root.right)
        leftTail?.let {
            it.right = root.right
            root.right = root.left
            root.left = null
        }
        return rightTail ?: leftTail
    }
    flattenToList(root)
}

/**
 * Using iterative method
 *
 * Stats
 * Runtime: 265 ms, faster than 85.71%
 * Memory Usage: 36.1 MB, less than 14.29%
 */
private fun flatten(root: TreeNode?): Unit {
    var pointer = root
    var temp: TreeNode?
    while (pointer != null) {
        if (pointer.left != null) {
            temp = pointer.left
            while (temp?.right != null) {
                temp = temp?.right
            }
            temp?.right = pointer?.right
            pointer?.right = pointer.left
            pointer.left = null
        }
        pointer = pointer.right
    }
}

private fun main() {

}
