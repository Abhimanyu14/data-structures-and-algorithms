package leetcode.leetcode_1315_sum_of_nodes_with_even_valued_grandparent

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 *
 * Using recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 39.9 MB, less than 50.00%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun sumEvenGrandparent(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    var result = 0
    fun getSum(current: TreeNode, isParentEven: Boolean, isGrandParentEven: Boolean) {
        if (isGrandParentEven) {
            result += current.`val`
        }
        current.left?.let {
            getSum(it, current.`val` % 2 == 0, isParentEven)
        }
        current.right?.let {
            getSum(it, current.`val` % 2 == 0, isParentEven)
        }
    }
    getSum(root, false, false)
    return result
}

private fun main() {

}
