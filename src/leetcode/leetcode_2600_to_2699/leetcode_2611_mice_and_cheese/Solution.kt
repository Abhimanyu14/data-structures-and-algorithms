package leetcode.leetcode_2600_to_2699.leetcode_2611_mice_and_cheese

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/mice-and-cheese/
 *
 * Using max heap
 *
 * Stats
 * Runtime: 670 ms, faster than 100.00%
 * Memory Usage: 70.4 MB, less than 100.00%
 */
private fun miceAndCheese(reward1: IntArray, reward2: IntArray, k: Int): Int {
    val maxHeap = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
        p2.first - p1.first
    }
    repeat(reward1.size) {
        maxHeap.offer(Pair(reward1[it] - reward2[it], it))
    }
    var result = 0
    repeat(k) {
        result += reward1[maxHeap.poll().second]
    }
    while (maxHeap.isNotEmpty()) {
        result += reward2[maxHeap.poll().second]
    }
    return result
}

private fun main() {

}
