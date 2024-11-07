package leetcode.leetcode_951_flip_equivalent_binary_trees

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/flip-equivalent-binary-trees/?envType=daily-question&envId=2024-10-24
 *
 * Using recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34.6 MB, less than 12.50%
 *
 * Time -
 * Space -
 */
private fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
    if (root1 == null && root2 == null) {
        return true
    }
    if (root1?.`val` != root2?.`val`) {
        return false
    }
    return (flipEquiv(root1?.left, root2?.left) && flipEquiv(root1?.right, root2?.right)) ||
            (flipEquiv(root1?.left, root2?.right) && flipEquiv(root1?.right, root2?.left))
}

private fun main() {

}
