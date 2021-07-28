package leetcode.leet_206_reverse_linked_list

import common.data_structures.createLinkedList
import common.data_structures.printLinkedList
import common.linkedlist.reverseList

fun main() {
    val input = intArrayOf(1, 2, 3, 4, 5)
    val listNode = createLinkedList(input)
    val result = reverseList(listNode)
    printLinkedList(result)
}
