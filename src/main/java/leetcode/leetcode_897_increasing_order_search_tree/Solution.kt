package leetcode.leetcode_897_increasing_order_search_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/increasing-order-search-tree/
 *
 * Using Tree traversal
 *
 * Stats
 * Runtime: 143 ms, faster than 32.35%
 * Memory Usage: 34.2 MB, less than 32.35%
 */
private fun increasingBST(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    fun traverse(head: TreeNode): Pair<TreeNode, TreeNode> {
        var newHead = head
        var newTail = head
        var temp: Pair<TreeNode, TreeNode>
        head.left?.let {
            temp = traverse(it)
            newHead = temp.first
            temp.second.right = head
        }
        head.left = null
        head.right?.let {
            temp = traverse(it)
            head.right = temp.first
            newTail = temp.second
        }
        return Pair(newHead, newTail)
    }
    return traverse(root).first
}
private fun main() {

}
