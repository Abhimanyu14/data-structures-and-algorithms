package leetcode.leetcode_763_partition_labels

import java.util.PriorityQueue
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/partition-labels/
 *
 * Data Structure - Map and PriorityQueue
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 47 ms, faster than 5.36%
 * Memory Usage: 38.3 MB, less than 28.57%
 *
 * Time - O(N * log(N))
 * Space - O(N)
 */
private fun partitionLabels(s: String): List<Int> {
    val result = mutableListOf<Int>()
    val start = mutableMapOf<Char, Int>()
    val end = mutableMapOf<Char, Int>()
    for (i in s.indices) {
        if (!start.contains(s[i])) {
            start[s[i]] = i
        }
        end[s[i]] = i
    }
    val pq = PriorityQueue<Pair<Char, Int>> { a, b ->
        a.second - b.second
    }
    for ((key, value) in start) {
        pq.offer(Pair(key, value))
    }
    while (pq.isNotEmpty()) {
        var polled = pq.poll()
        val currentStart = polled.second
        var currentEnd = end[polled.first]!!
        while (pq.isNotEmpty() && pq.peek().second < currentEnd) {
            polled = pq.poll()
            currentEnd = max(currentEnd, end[polled.first]!!)
        }
        result.add(currentEnd - currentStart + 1)
    }
    return result
}

private fun main() {

}
