package leetcode.leet_2_add_two_numbers

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val result = ListNode((l1!!.`val`.plus(l2!!.`val`)).rem(10))
    var remainder: Int = (l1.`val`.plus(l2.`val`)).div(10)
    var resultNode = result
    var firstNode = l1
    var secondNode = l2
    while (firstNode?.next != null || secondNode?.next != null || remainder != 0) {
        firstNode = firstNode?.next
        secondNode = secondNode?.next
        resultNode.next = ListNode(((firstNode?.`val` ?: 0).plus(secondNode?.`val` ?: 0).plus(remainder)).rem(10))
        resultNode = resultNode.next!!
        remainder = ((firstNode?.`val` ?: 0).plus(secondNode?.`val` ?: 0).plus(remainder)).div(10)
    }
    return result
}

fun main() {
    val input1 = ListNode(2)
    input1.next = ListNode(4)
    input1.next!!.next = ListNode(3)

    val input2 = ListNode(5)
    input2.next = ListNode(6)
    input2.next!!.next = ListNode(4)

    printNode(addTwoNumbers(input1, input2)!!)
}

fun printNode(ln: ListNode) {
    var l = ln
    print("${l.`val`} -> ")
    while (l.next != null) {
        l = l.next!!
        print("${l.`val`} -> ")
    }
    print("null")
}
