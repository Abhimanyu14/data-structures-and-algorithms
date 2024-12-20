package leetcode.leetcode_768_max_chunks_to_make_sorted_ii

import java.util.Stack

/**
 * leetcode - https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Monotonic Stack
 * Algorithm - Monotonic Stack and Iteration
 *
 * Difficulty - Hard
 *
 * Note: The part 1 question gives the base idea
 * https://leetcode.com/problems/max-chunks-to-make-sorted/solution/
 *
 * Stats
 * Runtime: 6 ms, faster than 100.00%
 * Memory Usage: 38.7 MB, less than 100.00%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun maxChunksToSorted(arr: IntArray): Int {
    val monotonicStack = Stack<Int>()
    for (i in arr.indices) {
        if (monotonicStack.isEmpty() || arr[i] >= monotonicStack.peek()) {
            monotonicStack.push(arr[i])
        } else {
            val top = monotonicStack.peek()
            while (monotonicStack.isNotEmpty() && monotonicStack.peek() > arr[i]) {
                monotonicStack.pop()
            }
            monotonicStack.push(top)
        }
    }
    return monotonicStack.size
}

private fun main() {

}
