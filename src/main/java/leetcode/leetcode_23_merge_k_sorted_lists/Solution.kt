package leetcode.leetcode_23_merge_k_sorted_lists

import data_structures_and_algorithms.linkedlist.ListNode
import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/merge-k-sorted-lists/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - PriorityQueue
 * Algorithm - Heapify
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 47 ms, faster than 26.94%
 * Memory Usage: 39.3 MB, less than 63.66%
 *
 * Time -
 * Space -
 */
private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val dummy = ListNode(-1)
    var currentNode: ListNode = dummy
    val priorityQueue = PriorityQueue<Pair<Int, ListNode>> { a, b -> // value, list, index
        if (a.second.`val` == b.second.`val`) {
            a.first - b.first
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
        val current = priorityQueue.poll()
        currentNode.next = current.second
        currentNode = currentNode.next!!
        current.second.next?.let {
            priorityQueue.offer(Pair(current.first, it))
        }
    }
    return dummy.next
}

private fun main() {

}
