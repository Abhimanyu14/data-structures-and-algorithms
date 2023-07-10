package leetcode.leet_2300_to_2399.leet_2331_evaluate_boolean_binary_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/evaluate-boolean-binary-tree/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 223 ms, faster than 95.45%
 * Memory Usage: 37.1 MB, less than 100.00%
 */
private fun evaluateTree(root: TreeNode?): Boolean {
    if (root?.left == null && root?.right == null) {
        return root?.`val` == 1
    }
    val left = evaluateTree(root.left)
    val right = evaluateTree(root.right)
    return if (root.`val` == 2) {
        left || right
    } else {
        left && right
    }
}

/**
 * leetcode - https://leetcode.com/problems/evaluate-boolean-binary-tree/
 *
 * Using recursion with optimization
 *
 * Stats
 * Runtime: 372 ms, faster than 72.73%
 * Memory Usage: 43.9 MB, less than 13.64%
 */
private fun evaluateTreeConcise(root: TreeNode?): Boolean {
    return if (root?.left == null) {
        return root?.`val` == 1
    } else if (root.`val` == 2) {
        evaluateTree(root.left) || evaluateTree(root.right)
    } else {
        evaluateTree(root.left) && evaluateTree(root.right)
    }
}

private fun main() {

}
