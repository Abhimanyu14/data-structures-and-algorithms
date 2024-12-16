package leetcode.leetcode_3264_final_array_state_after_k_multiplication_operations_i

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/
 *
 * Data Structure - PriorityQueue
 * Algorithm - Heapify
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 49 ms, faster than 26.32%
 * Memory Usage: 39.1 MB, less than 78.95%
 *
 * Time - O(N * log(N))
 * Space - O(N)
 */
private fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
    val result = IntArray(nums.size)
    val priorityQueue = PriorityQueue<Pair<Int, Int>>() { a , b -> // value, index
        if (a.first == b.first) {
            a.second.compareTo(b.second)
        } else {
            a.first.compareTo(b.first)
        }
    }
    for (i in nums.indices) {
        priorityQueue.offer(Pair(nums[i], i))
    }
    for (i in 0..<k) {
        val current = priorityQueue.poll()
        priorityQueue.offer(Pair(current.first * multiplier, current.second))
    }
    while (priorityQueue.isNotEmpty()) {
        val current = priorityQueue.poll()
        result[current.second] = current.first
    }
    return result
}

private fun main() {

}
