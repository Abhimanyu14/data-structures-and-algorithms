package leetcode.leetcode_1825_finding_mk_average

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/finding-mk-average/submissions/1623677652/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [ArrayDeque] (Queue), [PriorityQueue]
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * addElement: O(1)
 * calculateMKAverage: O(m * log(m))
 *
 * Space - O(N)
 * addElement: O(N)
 * calculateMKAverage: O(N)
 *
 * Companies - Google
 */
private class MKAverageUsingBruteForce(private val m: Int, private val k: Int) {
    private val queue = ArrayDeque<Int>()

    fun addElement(num: Int) {
        if (queue.size == m) {
            queue.removeFirst()
        }
        queue.addLast(num)
    }

    fun calculateMKAverage(): Int {
        if (queue.size < m) {
            return -1
        }
        val minHeap = PriorityQueue<Int>()
        repeat(m) {
            val num = queue.removeFirst()
            queue.addLast(num)
            minHeap.offer(num)
        }
        repeat(k) {
            minHeap.poll()
        }
        var result = 0L
        repeat(m - (2 * k)) {
            result += minHeap.poll()
        }
        return (result / (m - (2 * k))).toInt()
    }
}

private fun main() {

}
