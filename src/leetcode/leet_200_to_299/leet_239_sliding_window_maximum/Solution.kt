package leetcode.leet_200_to_299.leet_239_sliding_window_maximum

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/sliding-window-maximum/
 *
 * Using Sliding window
 *
 * Stats
 * Time Limit Exceeded
 */
fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val priorityQueue = PriorityQueue<Int> { o1, o2 ->
        o2 - o1
    }
    val result = mutableListOf<Int>()
    var start = 0
    var end = 0
    while(end < nums.size && end < k - 1) {
        priorityQueue.offer(nums[end++])
    }
    while (end < nums.size) {
        priorityQueue.offer(nums[end++])
        result.add(priorityQueue.peek())
        priorityQueue.remove(nums[start++])
    }
    return result.toIntArray()
}

private fun main() {

}
