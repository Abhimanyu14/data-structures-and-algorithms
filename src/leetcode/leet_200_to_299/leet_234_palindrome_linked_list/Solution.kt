package leetcode.leet_200_to_299.leet_234_palindrome_linked_list

import data_structures.linkedlist.ListNode
import data_structures.linkedlist.createLinkedList

/**
 * Using recursion
 *
 * Stats
 * Runtime: 497 ms, faster than 100.00%
 * Memory Usage: 87.2 MB, less than 30.32%
 */
private fun isPalindrome(head: ListNode?): Boolean {
    var size = 0
    var counter = head
    while (counter != null) {
        size++
        counter = counter.next
    }
    return isPalindromeHelper(head, size).second
}

private fun isPalindromeHelper(head: ListNode?, size: Int): Pair<ListNode?, Boolean> {
    if (size == 1) {
        return Pair(head?.next, true)
    }
    if (size == 2) {
        return if (head?.`val` == head?.next?.`val`) {
            Pair(head?.next?.next, true)
        } else {
            Pair(null, false)
        }
    }
    val nextNode = isPalindromeHelper(head?.next, size - 2).first
    return if (nextNode?.`val` == head?.`val`) {
        Pair(nextNode?.next, true)
    } else {
        Pair(null, false)
    }
}

private fun main() {
    val input1 = intArrayOf(1, 2, 3, 3, 2, 1)
    println(isPalindrome(createLinkedList(input1)))

    val input2 = intArrayOf(1, 2)
    println(isPalindrome(createLinkedList(input2)))

    val input3 = intArrayOf(1, 2, 3, 4, 3, 2, 1)
    println(isPalindrome(createLinkedList(input3)))

    val input4 = intArrayOf(1)
    println(isPalindrome(createLinkedList(input4)))

    val input5 = intArrayOf(1, 1)
    println(isPalindrome(createLinkedList(input5)))

    val input6 = intArrayOf(1, 2)
    println(isPalindrome(createLinkedList(input6)))

    val input7 = intArrayOf(1, 2, 1)
    println(isPalindrome(createLinkedList(input7)))

    val input8 = intArrayOf(1, 2, 3)
    println(isPalindrome(createLinkedList(input8)))
}
