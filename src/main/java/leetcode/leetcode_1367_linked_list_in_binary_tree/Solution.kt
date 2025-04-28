package leetcode.leetcode_1367_linked_list_in_binary_tree

import data_structures.TreeNode
import data_structures.linkedlist.ListNode


/**
 * leetcode - https://leetcode.com/problems/linked-list-in-binary-tree/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */

private fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
    fun searchInTree(
        node: TreeNode?,
        patternIndex: Int,
        pattern: List<Int>,
        prefixTable: List<Int>,
    ): Boolean {
        var patternIndexCopy = patternIndex
        if (node == null) return false

        while (patternIndexCopy > 0 && node.`val` != pattern[patternIndexCopy]) {
            patternIndexCopy = prefixTable[patternIndexCopy - 1]
        }
        patternIndexCopy += if (node.`val` == pattern[patternIndexCopy]) 1 else 0

        // Check if the pattern is fully matched
        if (patternIndexCopy == pattern.size) return true

        // Recursively search left and right subtrees
        return (searchInTree(node.left, patternIndexCopy, pattern, prefixTable) ||
                searchInTree(node.right, patternIndexCopy, pattern, prefixTable))
    }

    // Build the pattern and prefix table from the linked list
    var headCopy: ListNode? = head
    val pattern: MutableList<Int> = ArrayList()
    val prefixTable: MutableList<Int> = ArrayList()
    headCopy?.`val`?.let {
        pattern.add(it)
    }
    prefixTable.add(0)
    var patternIndex = 0
    headCopy = headCopy?.next

    while (headCopy != null) {
        while (patternIndex > 0 && headCopy.`val` != pattern[patternIndex]) {
            patternIndex = prefixTable[patternIndex - 1]
        }
        patternIndex += if (headCopy.`val` == pattern[patternIndex]) 1 else 0
        pattern.add(headCopy.`val`)
        prefixTable.add(patternIndex)
        headCopy = headCopy.next
    }

    // Perform DFS to search for the pattern in the tree
    return searchInTree(root, 0, pattern, prefixTable)
}

private fun main() {

}
