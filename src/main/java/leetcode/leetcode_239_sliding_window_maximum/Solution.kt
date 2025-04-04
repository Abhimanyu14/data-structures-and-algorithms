package leetcode.leetcode_239_sliding_window_maximum

/**
 * leetcode - https://leetcode.com/problems/sliding-window-maximum/
 *
 * Using Sliding window and stack
 *
 * Stats
 * Runtime: 923 ms, faster than 61.78%
 * Memory Usage: 55.2 MB, less than 51.78%
 *
 * Companies - Meta
 */
private fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val deque = ArrayDeque<Int>()
    var i = 0
    while (i < k) {
        while (deque.isNotEmpty() && nums[deque.last()] <= nums[i]) {
            deque.removeLast()
        }
        deque.addLast(i)
        i++
    }
    val result = mutableListOf<Int>()
    result.add(nums[deque.first()])
    while (i < nums.size) {
        if (deque.first() == i - k) {
            deque.removeFirst()
        }
        while (deque.isNotEmpty() && nums[deque.last()] <= nums[i]) {
            deque.removeLast()
        }
        deque.addLast(i)
        result.add(nums[deque.first()])
        i++
    }
    return result.toIntArray()
}

private fun main() {

}
