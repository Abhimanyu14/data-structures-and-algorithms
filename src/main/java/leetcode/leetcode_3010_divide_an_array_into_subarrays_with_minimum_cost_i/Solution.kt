package leetcode.leetcode_3010_divide_an_array_into_subarrays_with_minimum_cost_i

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/
 *
 * Data Structure - PriorityQueue
 * Algorithm - Heap
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(1)
 *
 * Companies -
 */
private fun minimumCost(nums: IntArray): Int {
    var result = nums[0]
    val maxHeap = PriorityQueue<Int> { a, b ->
        b - a
    }
    for (i in 1..nums.lastIndex) {
        maxHeap.offer(nums[i])
        if (maxHeap.size > 2) {
            maxHeap.poll()
        }
    }
    while (maxHeap.isNotEmpty()) {
        result += maxHeap.poll()
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/
 *
 * Data Structure - PriorityQueue
 * Algorithm - Heap
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies -
 */
private fun minimumCostUsingMinHeap(nums: IntArray): Int {
    var result = nums[0]
    val minHeap = PriorityQueue<Int>()
    for (i in 1..nums.lastIndex) {
        minHeap.offer(nums[i])
    }
    result += minHeap.poll() + minHeap.poll()
    return result
}

private fun main() {

}
