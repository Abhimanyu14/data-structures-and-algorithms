package leetcode.leetcode_1642_furthest_building_you_can_reach

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/furthest-building-you-can-reach/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=MEDIUM
 *
 * Data Structure - Priority Queue
 * Algorithm - Greedy
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 79 ms, faster than 9.09%
 * Memory Usage: 51.8 MB, less than 54.55%
 *
 * Time - O(N * log(N))
 * Space - O(N)
 */
private fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
    var result = 0
    var laddersLeft = ladders
    var bricksLeft = bricks
    val maxHeap = PriorityQueue<Int> { a, b -> b - a }
    while (result < heights.lastIndex) {
        if (heights[result + 1] <= heights[result]) {
            result++
        } else {
            if (laddersLeft == 0 && bricksLeft == 0) {
                return result
            }
            val diff = heights[result + 1] - heights[result]
            maxHeap.offer(diff)
            while (laddersLeft > 0 || bricksLeft > 0) {
                if (bricksLeft - diff >= 0) {
                    bricksLeft -= diff
                    result++
                    break
                } else if (laddersLeft > 0 && maxHeap.isNotEmpty()) {
                    laddersLeft--
                    bricksLeft += maxHeap.poll()
                } else {
                    return result
                }
            }
        }
    }
    return result
}

private fun main() {

}
