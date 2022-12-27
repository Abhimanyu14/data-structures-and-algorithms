package leetcode.leet_900_to_999.leet_912_sort_an_array

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/sort-an-array/
 *
 * Using priority queue
 *
 * Stats
 * Runtime: 1268 ms, faster than 33.89%
 * Memory Usage: 76.7 MB, less than 71.08%
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
