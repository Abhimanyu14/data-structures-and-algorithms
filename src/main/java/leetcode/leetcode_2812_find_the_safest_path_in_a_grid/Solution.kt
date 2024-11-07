package leetcode.leetcode_2812_find_the_safest_path_in_a_grid

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/find-the-safest-path-in-a-grid/solution/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 1066 ms, faster than 100.00%
 * Memory Usage: 84.5 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun maximumSafenessFactor(grid: List<List<Int>>): Int {
    // Directions for moving to neighboring cells: right, left, down, up
    val dir: Array<IntArray> = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

    // Check if a given cell lies within the grid
    fun isValidCell(mat: Array<IntArray>, i: Int, j: Int): Boolean {
        val n = mat.size
        return i >= 0 && j >= 0 && i < n && j < n
    }

    val n = grid.size
    val mat = Array(n) { IntArray(n) }
    val multiSourceQueue: Queue<IntArray> = LinkedList()

    // To make modifications and navigation easier, the grid is converted into a 2-d array
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (grid[i][j] == 1) {
                // Push thief coordinates to the queue
                multiSourceQueue.add(intArrayOf(i, j))
                // Mark thief cell with 0
                mat[i][j] = 0
            } else {
                // Mark empty cell with -1
                mat[i][j] = -1
            }
        }
    }

    // Calculate safeness factor for each cell using BFS
    while (!multiSourceQueue.isEmpty()) {
        var size = multiSourceQueue.size
        while (size-- > 0) {
            val curr = multiSourceQueue.poll()
            // Check neighboring cells
            for (d in dir) {
                val di = curr[0] + d[0]
                val dj = curr[1] + d[1]
                val `val` = mat[curr[0]][curr[1]]
                // Check if the neighboring cell is valid and unvisited
                if (isValidCell(mat, di, dj) && mat[di][dj] == -1) {
                    // Update safeness factor and push to the queue
                    mat[di][dj] = `val` + 1
                    multiSourceQueue.add(intArrayOf(di, dj))
                }
            }
        }
    }

    // Priority queue to prioritize cells with higher safeness factor
    val pq = PriorityQueue { a: IntArray, b: IntArray ->
        b[2] - a[2]
    }
    // Push starting cell to the priority queue
    pq.add(intArrayOf(0, 0, mat[0][0])) // [x-coordinate, y-coordinate, maximum_safeness_till_now]
    mat[0][0] = -1 // Mark the source cell as visited

    // BFS to find the path with maximum safeness factor
    while (!pq.isEmpty()) {
        val curr = pq.poll()
        // If reached the destination, return safeness factor
        if (curr[0] == n - 1 && curr[1] == n - 1) {
            return curr[2]
        }
        // Explore neighboring cells
        for (d in dir) {
            val di = d[0] + curr[0]
            val dj = d[1] + curr[1]
            if (isValidCell(mat, di, dj) && mat[di][dj] != -1) {
                // Update safeness factor for the path and mark the cell as visited
                pq.add(
                    intArrayOf(
                        di, dj,
                        min(curr[2].toDouble(), mat[di][dj].toDouble()).toInt()
                    )
                )
                mat[di][dj] = -1
            }
        }
    }

    return -1 // No valid path found
}

private fun main() {

}
