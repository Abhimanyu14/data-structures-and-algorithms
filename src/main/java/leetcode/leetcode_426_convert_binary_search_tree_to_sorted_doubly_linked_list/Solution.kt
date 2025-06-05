package leetcode.leetcode_426_convert_binary_search_tree_to_sorted_doubly_linked_list

/**
 * leetcode - https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * Premium Question
 *
 * Data Structure - Tree, Double Linked List
 * Algorithm - DFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
}

private fun treeToDoublyList(root: Node?): Node? {
    if (root == null) {
        return null
    }

    fun flatten(current: Node): Pair<Node, Node> {
        if (current.left == null && current.right == null) {
            return Pair(current, current)
        }

        if (current.left != null && current.right == null) {
            val (leftStart, leftEnd) = flatten(current.left!!)
            leftEnd.right = current
            current.left = leftEnd
            return Pair(leftStart, current)
        }

        if (current.left == null && current.right != null) {
            val (rightStart, rightEnd) = flatten(current.right!!)
            current.right = rightStart
            rightStart.left = current
            return Pair(current, rightEnd)
        }

        val (leftStart, leftEnd) = flatten(current.left!!)
        val (rightStart, rightEnd) = flatten(current.right!!)
        leftEnd.right = current
        current.left = leftEnd
        current.right = rightStart
        rightStart.left = current
        return Pair(leftStart, rightEnd)
    }

    val (start, end) = flatten(root)
    start.left = end
    end.right = start
    return start
}

private fun main() {

}
