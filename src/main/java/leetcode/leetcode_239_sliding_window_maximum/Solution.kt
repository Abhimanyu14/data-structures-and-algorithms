package leetcode.leetcode_239_sliding_window_maximum

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/sliding-window-maximum/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [ArrayDeque], [List]
 * Algorithm - Sliding Window
 *
 * ArrayDeque methods - [ArrayDeque.isNotEmpty], [ArrayDeque.first], [ArrayDeque.addLast],
 * [ArrayDeque.removeFirst], [ArrayDeque.removeLast]
 * List methods - [MutableList.add], [MutableList.toIntArray]
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 55 ms, faster than 88.13%
 * Memory Usage: 64.28 MB, less than 45.21%
 *
 * Time - O(N)
 * Space - O(k)
 *
 * Companies - Meta
 */
private fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val result = IntArray(nums.size - k + 1)
    val deque = ArrayDeque<Int>()
    for (i in nums.indices) {
        // Step 1: Remove the first number if it is out of the window
        if (i >= k && deque.first() == i - k) {
            deque.removeFirst()
        }
        // Step 2: Remove numbers smaller that the current one
        while (deque.isNotEmpty() && nums[deque.last()] <= nums[i]) {
            deque.removeLast()
        }
        // Step 3: Add current number to the Deque
        deque.addLast(i)

        // Step 4: Update result
        if (i >= k - 1) {
            result[i - k + 1] = nums[deque.first()]
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/sliding-window-maximum/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [PriorityQueue]
 * Algorithm - Sliding Window
 *
 * Difficulty - Hard
 *
 * Time - O(N)
 * Space - O(k)
 *
 * Companies - Meta
 */
private fun maxSlidingWindowUsingPriorityQueue(nums: IntArray, k: Int): IntArray {
    val result = IntArray(nums.size - k + 1)
    val priorityQueue = PriorityQueue<Pair<Int, Int>> { a, b -> // Value, Index
        if (a.first == b.first) {
            a.second - b.second
        } else {
            b.first - a.first
        }
    }
    var index = 0
    while (index <= nums.lastIndex) {
        while (priorityQueue.isNotEmpty() &&
            (priorityQueue.peek().second <= index - k || priorityQueue.peek().first < nums[index])
        ) {
            priorityQueue.poll()
        }
        priorityQueue.offer(Pair(nums[index], index))
        index++
        if (index >= k) {
            result[index - k] = priorityQueue.peek().first
        }
    }
    return result
}

private fun main() {

}
