package leetcode.leetcode_1214_two_sum_bsts

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/two-sum-bsts/
 *
 * Using set
 *
 * Stats
 * Runtime: 267 ms, faster than 14.29%
 * Memory Usage: 39.5 MB, less than 28.57%
 */
private fun twoSumBSTs(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
    val targetSet = mutableSetOf<Int>()

    fun parseTree1(head: TreeNode?) {
        if (head == null) {
            return
        }
        targetSet.add(target - head.`val`)
        parseTree1(head.left)
        parseTree1(head.right)
    }

    fun parseTree2(head: TreeNode?): Boolean {
        if (head == null) {
            return false
        }
        if (targetSet.contains(head.`val`)) {
            return true
        }
        return parseTree2(head.left) || parseTree2(head.right)
    }

    parseTree1(root1)
    println(targetSet)
    return parseTree2(root2)
}

private fun main() {

}
