package common.data_structures

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun createLinkedList(arr: IntArray): ListNode? {
    if (arr.isEmpty()) {
        return null
    }
    val listNode = ListNode(arr.first())
    var listPointer = listNode

    for (i in 1 until arr.size) {
        listPointer.next = ListNode(arr[i])
        listPointer = listPointer.next!!
    }
    return listNode
}

fun lastNode(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    var pointer = head
    while (pointer?.next != null) {
        pointer = pointer.next
    }
    return pointer
}

fun printLinkedList(listNode: ListNode?) {
    if (listNode == null) {
        return
    }
    var listNodePointer = listNode
    print("${listNodePointer.`val`}")
    while (listNodePointer?.next != null) {
        listNodePointer = listNodePointer.next!!
        print("-> ${listNodePointer.`val`}")
    }
    println()
}
