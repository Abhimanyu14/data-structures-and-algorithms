package leetcode.leetcode_407_trapping_rain_water_ii

import java.util.PriorityQueue
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/trapping-rain-water-ii/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [PriorityQueue], [Array]
 * Algorithm - BFS, Min Heap
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time - O(m * n * log(m * n))
 * Space - O(m * n)
 *
 * Companies - Google
 */
private fun trapRainWater(heightMap: Array<IntArray>): Int {
    var result = 0
    val minHeap = PriorityQueue<Triple<Int, Int, Int>> { a, b ->
        a.first - b.first
    }
    val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
    for (i in heightMap.indices) {
        for (j in heightMap[0].indices) {
            if (i == 0 || j == 0 || i == heightMap.lastIndex || j == heightMap[0].lastIndex) {
                minHeap.offer(Triple(heightMap[i][j], i, j))
                heightMap[i][j] = -1
            }
        }
    }
    var maxHeight = -1
    while (minHeap.isNotEmpty()) {
        val (current, x, y) = minHeap.poll()
        maxHeight = max(maxHeight, current)
        result += maxHeight - current
        for ((x1, y1) in directions) {
            if (x + x1 > 0 && y + y1 > 0 && x + x1 <= heightMap.lastIndex && y + y1 <= heightMap[0].lastIndex && heightMap[x + x1][y + y1] != -1) {
                minHeap.offer(Triple(heightMap[x + x1][y + y1], x + x1, y + y1))
                heightMap[x + x1][y + y1] = -1
            }
        }
    }
    return result
}

private fun main() {

}
