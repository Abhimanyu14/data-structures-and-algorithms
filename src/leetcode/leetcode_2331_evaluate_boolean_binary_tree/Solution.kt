package leetcode.leetcode_2331_evaluate_boolean_binary_tree

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/evaluate-boolean-binary-tree/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 179 ms, faster than 100.00%
 * Memory Usage: 38.4 MB, less than 15.00%
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
 * Runtime: 193 ms, faster than 70.83%
 * Memory Usage: 38.2 MB, less than 33.33%
 */
private fun evaluateTreeConcise(root: TreeNode?): Boolean {
    return if (root?.left == null) {
        return root?.`val` == 1
    } else if (root.`val` == 2) {
        evaluateTreeConcise(root.left) || evaluateTree(root.right)
    } else {
        evaluateTreeConcise(root.left) && evaluateTree(root.right)
    }
}

private fun main() {

}
