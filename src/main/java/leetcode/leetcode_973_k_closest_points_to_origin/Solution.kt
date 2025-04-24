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
 * Time - O(N)
 * Space - O(k)
 *
 * Companies - Meta
 */
private fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    fun getDistanceSquare(point1: IntArray): Int {
        return (point1[1] * point1[1]) + (point1[0] * point1[0])
    }

    val maxHeap = PriorityQueue<Pair<Int, IntArray>> { a, b ->
        b.first - a.first
    }
    for (point in points) {
        maxHeap.offer(Pair(getDistanceSquare(point), point))
        if (maxHeap.size > k) {
            maxHeap.poll()
        }
    }
    val result = mutableListOf<IntArray>()
    while (maxHeap.isNotEmpty()) {
        result.add(maxHeap.poll().second)
    }
    return result.toTypedArray()
}

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
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun kClosestUsingMinHeap(points: Array<IntArray>, k: Int): Array<IntArray> {
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
