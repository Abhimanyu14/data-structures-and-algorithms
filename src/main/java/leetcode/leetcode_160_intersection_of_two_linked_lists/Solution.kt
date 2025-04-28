package leetcode.leetcode_160_intersection_of_two_linked_lists

import data_structures.linkedlist.ListNode
import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Using length of linked list and loops
 *
 * Stats
 * Runtime: 159 ms, faster than 89.09%
 * Memory Usage: 38.9 MB, less than 43.03%
 */
private fun getIntersectionNode(headA: ListNode?, headB:ListNode?):ListNode? {
    var size1 = 0
    var size2 = 0
    var temp1 = headA
    var temp2 = headB
    while(temp1 != null) {
        size1++
        temp1 = temp1.next
    }
    while(temp2 != null) {
        size2++
        temp2 = temp2.next
    }
    val difference = abs(size1 - size2)
    temp1 = headA
    temp2 = headB
    if (size1 > size2) {
        for (i in 0..<difference) {
            temp1 = temp1?.next
        }
    } else if (size2 > size1) {
        for (i in 0..<difference) {
            temp2 = temp2?.next
        }
    }
    while (temp1 != null) {
        if (temp1 == temp2) {
            return temp1
        }
        temp1 = temp1.next
        temp2 = temp2?.next
    }
    return null
}

private fun main() {

}
