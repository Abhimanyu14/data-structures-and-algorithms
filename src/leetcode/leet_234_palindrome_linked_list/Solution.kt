package leetcode.leet_234_palindrome_linked_list

import common.data_structures.ListNode
import common.data_structures.createLinkedList

/**
 * Stats
 * Time limit exceeded
 */
fun isPalindrome(head: ListNode?): Boolean {
    var headPointer = head
    var str = ""
    while (headPointer != null) {
        str += headPointer.`val`
        headPointer = headPointer.next
    }
    return common.string.isStringPalindrome(str)
}

fun main() {
    val input = intArrayOf(1, 2, 2, 1)
    val listNode = createLinkedList(input)
    val result = isPalindrome(listNode)
    println(result)
}
