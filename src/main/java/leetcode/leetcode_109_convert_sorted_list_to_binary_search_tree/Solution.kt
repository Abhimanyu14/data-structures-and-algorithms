package leetcode.leetcode_109_convert_sorted_list_to_binary_search_tree

import data_structures.TreeNode
import data_structures.linkedlist.ListNode

/**
 * leetcode - https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun sortedListToBST(head: ListNode?): TreeNode? {
    if (head == null) {
        return null
    }
    var current: ListNode? = head
    var size = 0
    while (current != null) {
        current = current.next
        size++
    }
    var newHead: ListNode? = head
    fun convertListToBST(start: Int, end: Int): TreeNode? {
        if (start > end) {
            return null
        }
        val mid = (start + end) / 2
        val leftChild = convertListToBST(start, mid - 1)
        val node = TreeNode(newHead?.`val` ?: 0).apply {
            left = leftChild
        }
        newHead = newHead?.next
        val rightChild = convertListToBST(mid + 1, end)
        node.right = rightChild
        return node
    }
    return convertListToBST(0, size - 1)
}

private fun main() {

}
