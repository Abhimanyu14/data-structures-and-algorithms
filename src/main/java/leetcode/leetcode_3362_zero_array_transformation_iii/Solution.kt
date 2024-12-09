package leetcode.leetcode_3362_zero_array_transformation_iii

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/zero-array-transformation-iii/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - PriorityQueue
 * Algorithm - Sorting and Heap iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 311 ms, faster than 23.08%
 * Memory Usage: 116.3 MB, less than 7.69%
 *
 * Time -
 * Space -
 */
private fun maxRemoval(nums: IntArray, queries: Array<IntArray>): Int {
    var result = 0
    val startQueue = PriorityQueue<IntArray> { a, b ->
        a[0] - b[0] // Sort by start time in ascending
    }
    val availableQueue = PriorityQueue<IntArray> { a, b ->
        b[1] - a[1] // Sort by end time in descending
    }
    val inProgressQueue = PriorityQueue<IntArray> { a, b ->
        a[1] - b[1] // Sort by end time in ascending
    }
    queries.forEach {
        startQueue.offer(it)
    }
    var currentSum = 0
    for (i in nums.indices) {
        while (inProgressQueue.isNotEmpty() && inProgressQueue.first()[1] == i - 1) {
            inProgressQueue.poll()
            currentSum--
        }
        while (startQueue.isNotEmpty() && startQueue.first()[0] == i) {
            availableQueue.offer(startQueue.poll())
        }
        while (availableQueue.isNotEmpty() && currentSum < nums[i]) {
            val current = availableQueue.poll()
            if (current[1] >= i) {
                currentSum++
                inProgressQueue.offer(current)
                result++
            }
        }
        if (currentSum < nums[i]) {
            return -1
        }
    }
    return queries.size - result
}

private fun main() {

}
