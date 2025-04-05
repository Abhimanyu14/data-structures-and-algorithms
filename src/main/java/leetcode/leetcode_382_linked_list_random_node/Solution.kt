package leetcode.leetcode_382_linked_list_random_node

import data_structures_and_algorithms.linkedlist.ListNode
import kotlin.random.Random

/**
 * leetcode - https://leetcode.com/problems/linked-list-random-node/?envType=problem-list-v2&envId=randomized
 *
 * Data Structure - [Random]
 * Algorithm - Randomization
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private class Solution(val head: ListNode?) {
    var size = 0

    init {
        var currentNode = head
        while (currentNode != null) {
            size++
            currentNode = currentNode.next
        }
    }

    fun getRandom(): Int {
        var currentNode = head
        val index = Random.nextInt(size)
        for (i in 0..<index) {
            currentNode = currentNode?.next
        }
        return currentNode?.`val` ?: 0
    }
}

private fun main() {

}
