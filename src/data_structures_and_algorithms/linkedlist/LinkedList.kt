package data_structures_and_algorithms.linkedlist

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun createLinkedList(arr: IntArray): ListNode? {
    if (arr.isEmpty()) {
        return null
    }
    val listHead = ListNode(arr.first())
    var listPointer: ListNode? = listHead
    for (i in 1..arr.lastIndex) {
        listPointer?.next = ListNode(arr[i])
        listPointer = listPointer?.next
    }
    return listHead
}

fun printLinkedList(listNode: ListNode?) {
    if (listNode == null) {
        println("Empty list")
        return
    }
    var listPointer: ListNode? = listNode
    print("${listPointer?.`val`}")
    while (listPointer?.next != null) {
        listPointer = listPointer.next
        print("-> ${listPointer?.`val`}")
    }
    println()
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
