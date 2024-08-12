package leetcode.leet_700_to_799.leet_703_kth_largest_element_in_a_stream

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * TODO(Abhi) - To complete
 *
 * Using
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 */
class KthLargest(
    val k: Int,
    nums: IntArray,
) {
    private val minHeap: PriorityQueue<Int> = PriorityQueue(k) { o1, o2 ->
        o1 - o2
    }

    init {
        nums.forEach { add(it) }
    }

    fun add(`val`: Int): Int {
        if (minHeap.size < k) {
            minHeap.offer(`val`)
        } else if (minHeap.peek() < `val`) {
            minHeap.poll()
            minHeap.offer(`val`)
        }
        return minHeap.peek()
    }
}

private fun main() {

}
