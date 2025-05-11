package leetcode.leetcode_234_palindrome_linked_list

import data_structures.linkedlist.ListNode
import data_structures.linkedlist.createLinkedList

/**
 * leetcode - https://leetcode.com/problems/palindrome-linked-list/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [StringBuilder]
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta, Microsoft
 */
private fun isPalindrome(head: ListNode?): Boolean {
    // Step 1: Find the middle node
    var left = head
    var right = head
    while (right?.next != null) {
        left = left?.next
        right = right.next?.next
    }

    // Step 2: Reverse the linked list from the middle to the last
    var prev: ListNode? = null
    var current = left
    while (current != null) {
        val temp = current.next
        current.next = prev
        prev = current
        current = temp
    }

    // Step 3: Check for palindrome
    left = head
    right = prev
    while (right != null) {
        if (left?.`val` != right.`val`) {
            return false
        }
        left = left.next
        right = right.next
    }
    return true
}

/**
 * Leetcode optimization
 */
private fun isPalindromeReusingVariables(head: ListNode?): Boolean {
    // Step 1: Find the middle node
    var left = head
    var right = head
    while (right?.next != null) {
        left = left?.next
        right = right.next?.next
    }

    // Step 2: Reverse the linked list from the middle to the last
    right = left
    left = null
    while (right != null) {
        val temp = right.next
        right.next = left
        left = right
        right = temp
    }

    // Step 3: Check for palindrome
    right = left
    left = head
    while (right != null) {
        if (left?.`val` != right.`val`) {
            return false
        }
        left = left.next
        right = right.next
    }
    return true
}

/**
 * leetcode - https://leetcode.com/problems/palindrome-linked-list/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [StringBuilder]
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta, Microsoft
 */
private fun isPalindromeUsingStringBuilder(head: ListNode?): Boolean {
    val stringBuilder = StringBuilder()
    var current = head
    while (current != null) {
        stringBuilder.append(current.`val`)
        current = current.next
    }
    var left = 0
    var right = stringBuilder.lastIndex
    while (left < right) {
        if (stringBuilder[left] != stringBuilder[right]) {
            return false
        }
        left++
        right--
    }
    return true
}
