package leetcode.leetcode_239_sliding_window_maximum

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
    val result = mutableListOf<Int>()
    val deque = ArrayDeque<Int>()
    var current = 0
    fun addCurrentToDeque() {
        while (deque.isNotEmpty() && nums[deque.last()] <= nums[current]) {
            deque.removeLast()
        }
        deque.addLast(current)
        current++
    }
    while (current < k) {
        addCurrentToDeque()
    }
    result.add(nums[deque.first()])
    while (current < nums.size) {
        if (deque.first() == current - k) {
            deque.removeFirst()
        }
        addCurrentToDeque()
        result.add(nums[deque.first()])
    }
    return result.toIntArray()
}

private fun main() {

}
