package leetcode.leet_1600_to_1699.leet_1669_merge_in_between_linked_lists

import data_structures.linkedlist.ListNode

/**
 * WIP
 *
 * Stats
 *
 */
private fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
    // The indices are a bit confusing, refer to the question example to understand the indexing logic

    // Counter
    var counter = 0

    var aPos = list1
    var current = list1?.next

    // Find list2 tail node
    var list2Tail = list2
    while (list2Tail?.next != null) {
        list2Tail = list2Tail?.next
    }

    // Iterate till the node to which we want to attach list 2
    while (counter < b + 1) {
        if (counter == a - 1) {
            // Attach list 2 to the 'a' th node
            aPos?.next = list2
        } else if (counter < a) {
            // Increment if we have not reached ath node
            aPos = aPos?.next
        }
        counter++
        // To skip moving the current node position at the end of the loop
        if (counter < b + 1) {
            current = current?.next
        }
    }

    // Attach list 2 node tail to the current position in list 1
    list2Tail?.next = current
    return list1
}

private fun main() {

}
