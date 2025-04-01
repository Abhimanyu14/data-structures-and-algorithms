package leetcode.leetcode_973_k_closest_points_to_origin

import java.util.PriorityQueue
import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * Data Structure - [PriorityQueue] (Min Heap)
 * Algorithm - Heapify
 *
 * Math functions - [pow],
 * Type conversion methods - [toInt], [toDouble], [toTypedArray]
 * Priority Queue methods - [offer], [poll]
 *
 * Math concepts - Distance between two points
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    val minHeap = PriorityQueue<Pair<IntArray, Double>> { a, b ->
        (a.second - b.second).toInt()
    }

    fun getDistance(point: IntArray): Double {
        return (point[0].toDouble().pow(2.0) + point[1].toDouble().pow(2.0))
    }
    for (point in points) {
        minHeap.offer(Pair(point, getDistance(point)))
    }
    for (i in 1..k) {
        val current = minHeap.poll()
        result.add(current.first)
    }
    return result.toTypedArray()
}

private fun main() {

}
