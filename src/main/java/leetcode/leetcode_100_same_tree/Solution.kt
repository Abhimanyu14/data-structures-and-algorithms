package leetcode.leetcode_100_same_tree

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/same-tree/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 159 ms, faster than 90.65%
 * Memory Usage: 33.3 MB, less than 98.87%
 */
private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) {
        return true
    }
    return (p?.`val` == q?.`val`) && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
}

/**
 * leetcode - https://leetcode.com/problems/same-tree/
 *
 * Using iteration
 *
 * Stats
 * TODO-Abhi: To complete
 */
private fun isSameTreeUsingDeque(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) {
        return true
    }
    if (p == null || q == null) {
        return false
    }
    val dequeP = ArrayDeque<TreeNode>()
    val dequeQ = ArrayDeque<TreeNode>()
    var tempP: TreeNode
    var tempQ: TreeNode
    dequeP.addLast(p)
    dequeP.addLast(q)
    while (dequeP.isNotEmpty() && dequeQ.isNotEmpty()) {
        tempP = dequeP.removeFirst()
        tempQ = dequeQ.removeFirst()
        if (tempP.`val` != tempQ.`val`) {
            return false
        }
        if (tempP.left == null && tempQ.left == null) {
            //
        } else if (tempP.left == null || tempQ.left == null) {
            return false
        } else {
            dequeP.addLast(tempP.left!!)
            dequeQ.addLast(tempQ.left!!)
        }
        if (tempP.right == null && tempQ.right == null) {
            //
        } else if (tempP.right == null || tempQ.right == null) {
            return false
        } else {
            dequeP.addLast(tempP.right!!)
            dequeQ.addLast(tempQ.right!!)
        }
    }
    if (dequeP.isNotEmpty() || dequeQ.isNotEmpty()) {
        return false
    }
    return true
}

private fun main() {

}
