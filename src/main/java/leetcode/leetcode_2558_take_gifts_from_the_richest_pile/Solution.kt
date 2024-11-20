package leetcode.leetcode_2558_take_gifts_from_the_richest_pile

import java.util.PriorityQueue
import kotlin.math.floor
import kotlin.math.sqrt

/**
 * leetcode - https://leetcode.com/problems/take-gifts-from-the-richest-pile/
 *
 * Using priority queue
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 46 ms, faster than 40.00%
 * Memory Usage: 36.9 MB, less than 60.00%
 *
 * Time - O(N log N)
 * Space -
 */
private fun pickGifts(gifts: IntArray, k: Int): Long {
    var result = 0L
    val pq = PriorityQueue<Int> { a, b ->
        b - a
    }
    gifts.forEach {
        pq.offer(it)
    }
    repeat(k) {
        val current = pq.poll()
        pq.offer(floor(sqrt(current.toDouble())).toInt())
    }
    while (pq.isNotEmpty()) {
        result += pq.poll()
    }
    return result
}

private fun main() {

}
