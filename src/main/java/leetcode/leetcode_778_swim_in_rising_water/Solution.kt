package leetcode.leetcode_778_swim_in_rising_water

import java.util.PriorityQueue
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/swim-in-rising-water/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * Data Structure - [PriorityQueue]
 * Algorithm - BFS, Heap
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time - O(N^2 * log(N))
 * Space - O(N^2)
 *
 * Companies - Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun swimInWater(grid: Array<IntArray>): Int {
    var result = 0
    val priorityQueue = PriorityQueue<Triple<Int, Int, Int>> { a, b ->
        a.first - b.first
    }
    priorityQueue.offer(Triple(grid[0][0], 0, 0))
    val visited = Array(grid.size) {
        BooleanArray(grid[0].size)
    }
    while (priorityQueue.isNotEmpty()) {
        val (currentHeight, x, y) = priorityQueue.poll()
        if (visited[x][y]) {
            continue
        }
        visited[x][y] = true
        result = max(result, currentHeight)
        if (x == grid.lastIndex && y == grid[0].lastIndex) {
            return result
        }
        if (x > 0 && !visited[x - 1][y]) {
            priorityQueue.offer(Triple(grid[x - 1][y], x - 1, y))
        }
        if (y > 0 && !visited[x][y - 1]) {
            priorityQueue.offer(Triple(grid[x][y - 1], x, y - 1))
        }
        if (x < grid.lastIndex && !visited[x + 1][y]) {
            priorityQueue.offer(Triple(grid[x + 1][y], x + 1, y))
        }
        if (y < grid[0].lastIndex && !visited[x][y + 1]) {
            priorityQueue.offer(Triple(grid[x][y + 1], x, y + 1))
        }
    }
    return result
}

private fun main() {

}
