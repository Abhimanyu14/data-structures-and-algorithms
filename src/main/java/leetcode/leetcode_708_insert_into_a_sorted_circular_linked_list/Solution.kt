package leetcode.leetcode_708_insert_into_a_sorted_circular_linked_list

/**
 * leetcode - https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
 * Premium Question
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - LinkedList
 * Algorithm - Traversal
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private class Node(var `val`: Int) {
    var next: Node? = null
}

private fun insert(head: Node?, insertVal: Int): Node? {
    if (head == null) {
        val newHead = Node(insertVal)
        newHead.next = newHead
        return newHead
    }
    if (head.next == head) {
        val newNode = Node(insertVal)
        newNode.next = head
        head.next = newNode
        return head
    }
    var current = head.next!!
    while (
        (current != head) &&
        !((current.`val` > current.next!!.`val`) && (insertVal >= current.`val`)) &&
        !((current.`val` > current.next!!.`val`) && (insertVal <= current.next!!.`val`)) &&
        !(insertVal >= current.`val` && insertVal < current.next!!.`val`)
    ) {
        current = current.next!!
    }
    val newNode = Node(insertVal)
    newNode.next = current.next
    current.next = newNode
    return head
}

private fun main() {

}
