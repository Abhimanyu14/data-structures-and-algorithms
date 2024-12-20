package leetcode.leetcode_2733_neither_minimum_nor_maximum

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/neither-minimum-nor-maximum/
 *
 * Data Structure - PriorityQueue
 * Algorithm - Heapify
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 24 ms, faster than 46.15%
 * Memory Usage: 58.1 MB, less than 23.08%
 *
 * Time -
 * Space -
 */
private fun findNonMinOrMax(nums: IntArray): Int {
    val minHeap = PriorityQueue<Int>()
    for (num in nums) {
        if (minHeap.size == 3 && num > minHeap.peek()) {
            minHeap.poll()
        }
        minHeap.offer(num)
    }
    if (minHeap.size <= 2) {
        return -1
    }
    minHeap.poll()
    return minHeap.poll()
}

private fun main() {

}
