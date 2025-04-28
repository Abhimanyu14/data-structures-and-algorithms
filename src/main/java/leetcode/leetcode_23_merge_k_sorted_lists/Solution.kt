package leetcode.leetcode_23_merge_k_sorted_lists

import data_structures.linkedlist.ListNode
import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/merge-k-sorted-lists/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [PriorityQueue]
 * Algorithm - Heapify
 *
 * PriorityQueue methods - [offer], [poll], [isNotEmpty]
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 47 ms, faster than 26.94%
 * Memory Usage: 39.3 MB, less than 63.66%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val dummyStarting = ListNode(-1)
    var currentNode: ListNode = dummyStarting
    val priorityQueue = PriorityQueue<Pair<Int, ListNode>> { a, b -> // list index, list
        if (a.second.`val` == b.second.`val`) {
            a.first - b.first // Choose the number from the list with the smaller index of 2 lists have same number
        } else {
            a.second.`val` - b.second.`val`
        }
    }
    for (i in lists.indices) {
        lists[i]?.let {
            priorityQueue.offer(Pair(i, it))
        }
    }
    while (priorityQueue.isNotEmpty()) {
        val (listIndex, node) = priorityQueue.poll()
        currentNode.next = node
        currentNode = currentNode.next!!
        node.next?.let {
            priorityQueue.offer(Pair(listIndex, it))
        }
    }
    return dummyStarting.next
}

private fun main() {

}
