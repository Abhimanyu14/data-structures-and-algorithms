package leetcode.leetcode_912_sort_an_array

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/sort-an-array/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [PriorityQueue]
 * Algorithm - Heapify
 *
 * Note: Use MergeSort, HeapSort, CountingSort or RadixSort.
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 685 ms, faster than 47.29%
 * Memory Usage: 50.7 MB, less than 87.60%
 *
 * Time - O(N * log(N))
 * Space - O(N)
 */
private fun sortArray(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    val priorityQueue = PriorityQueue<Int>()
    for (num in nums) {
        priorityQueue.offer(num)
    }
    for (i in nums.indices) {
        result[i] = priorityQueue.poll()
    }
    return result
}

private fun main() {

}
