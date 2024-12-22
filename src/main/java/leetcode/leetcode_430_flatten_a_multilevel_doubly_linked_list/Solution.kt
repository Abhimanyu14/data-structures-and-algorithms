package leetcode.leetcode_430_flatten_a_multilevel_doubly_linked_list

/**
 * leetcode - https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/?envType=problem-list-v2&envId=doubly-linked-list
 *
 * Data Structure - Doubly Linked List
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 173 ms, faster than 27.78%
 * Memory Usage: 37 MB, less than 5.56%
 *
 * Time -
 * Space -
 */
private class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}

private fun flatten(root: Node?): Node? {
    if (root == null) {
        return null
    }
    fun flattenLevel(head: Node): Pair<Node, Node> {
        var tail = head
        while (tail.next != null) {
            if (tail.child != null) {
                val nextNode = tail.next!!
                val (childHead, childTail) = flattenLevel(tail.child!!)
                tail.next = childHead
                childHead.prev = tail
                nextNode.prev = childTail
                childTail.next = nextNode
                tail.child = null
                tail = nextNode
            } else {
                tail = tail.next!!
            }
        }
        if (tail.child != null) {
            val (childHead, childTail) = flattenLevel(tail.child!!)
            tail.next = childHead
            childHead.prev = tail
            tail.child = null
            tail = childTail
        }
        return Pair(head, tail)
    }
    return flattenLevel(root).first
}

private fun main() {

}
