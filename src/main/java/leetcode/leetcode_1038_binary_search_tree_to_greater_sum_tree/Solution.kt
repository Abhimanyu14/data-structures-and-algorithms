package leetcode.leetcode_1038_binary_search_tree_to_greater_sum_tree

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/?envType=daily-question&envId=2024-06-25
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
private fun bstToGst(root: TreeNode?): TreeNode? {
    var sum = 0
    var node: TreeNode? = root

    // Get the node with the smallest value greater than this one.
    fun getSuccessor(node: TreeNode): TreeNode {
        var succ: TreeNode = node.right!!
        while (succ.left != null && succ.left !== node) {
            succ = succ.left!!
        }
        return succ
    }

    while (node != null) {
        // If there is no right subtree, then we can visit this node and
        // continue traversing left.
        if (node.right == null) {
            sum += node.`val`
            node.`val` = sum
            node = node.left
        } else {
            val succ: TreeNode = getSuccessor(node)
            //If the left subtree is null, then we have never been here before.
            if (succ.left == null) {
                succ.left = node
                node = node.right
            } else {
                succ.left = null
                sum += node.`val`
                node.`val` = sum
                node = node.left
            }
        }
    }

    return root
}

private fun main() {

}
