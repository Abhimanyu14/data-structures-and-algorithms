package data_structures.linkedlist

internal class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

internal fun createLinkedList(arr: IntArray): ListNode? {
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

internal fun printLinkedList(listNode: ListNode?) {
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

internal fun lastNode(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    var current = head
    while (current?.next != null) {
        current = current.next
    }
    return current
}
