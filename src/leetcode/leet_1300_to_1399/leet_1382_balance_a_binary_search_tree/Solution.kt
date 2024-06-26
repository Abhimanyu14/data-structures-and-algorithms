package leetcode.leet_1300_to_1399.leet_1382_balance_a_binary_search_tree

import data_structures_and_algorithms.TreeNode
import kotlin.math.floor
import kotlin.math.ln
import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/balance-a-binary-search-tree/?envType=daily-question&envId=2024-06-26
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun balanceBST(root: TreeNode?): TreeNode? {
    if (root == null) return null

    // Function to perform a right rotation
    fun rightRotate(parent: TreeNode, node: TreeNode) {
        val tmp: TreeNode = node.left!!
        node.left = tmp.right
        tmp.right = node
        parent.right = tmp
    }

    // Function to perform a left rotation
    fun leftRotate(parent: TreeNode, node: TreeNode) {
        val tmp: TreeNode = node.right!!
        node.right = tmp.left
        tmp.left = node
        parent.right = tmp
    }

    // Function to perform a series of left rotations to balance the vine
    fun makeRotations(vineHead: TreeNode, count: Int) {
        var current: TreeNode = vineHead
        for (i in 0..<count) {
            val tmp: TreeNode = current.right!!
            leftRotate(current, tmp)
            current = current.right!!
        }
    }

    // Step 1: Create the backbone (vine)
    // Temporary dummy node
    val vineHead = TreeNode(0)
    vineHead.right = root
    var current: TreeNode? = vineHead
    while (current?.right != null) {
        if (current?.right!!.left != null) {
            rightRotate(current!!, current?.right!!)
        } else {
            current = current?.right
        }
    }

    // Step 2: Count the nodes
    var nodeCount = 0
    current = vineHead.right!!
    while (current != null) {
        ++nodeCount
        current = current?.right
    }

    // Step 3: Create a balanced BST
    var m = 2.0.pow(floor(ln((nodeCount + 1).toDouble()) / ln(2.0))).toInt() - 1
    makeRotations(vineHead, nodeCount - m)
    while (m > 1) {
        m /= 2
        makeRotations(vineHead, m)
    }

    val balancedRoot: TreeNode = vineHead.right!!
    return balancedRoot
}

private fun main() {

}
