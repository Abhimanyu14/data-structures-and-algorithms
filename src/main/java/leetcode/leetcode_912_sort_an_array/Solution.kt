package leetcode.leetcode_912_sort_an_array

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/sort-an-array/
 *
 * Using priority queue
 *
 * Difficulty -
 *
 * Stats
 * Runtime: 685 ms, faster than 47.29%
 * Memory Usage: 50.7 MB, less than 87.60%
 *
 * Time -
 * Space -
 */
private fun sortArray(nums: IntArray): IntArray {
    val priorityQueue = PriorityQueue<Int> { a, b ->
        a - b
    }
    nums.forEach {
        priorityQueue.offer(it)
    }
    val result = mutableListOf<Int>()
    while (priorityQueue.isNotEmpty()) {
        result.add(priorityQueue.poll())
    }
    return result.toIntArray()
}

private fun main() {
    println(sortArray(intArrayOf(5, 1, 1, 2, 0, 0)).joinToString(", "))
}
