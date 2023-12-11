package leetcode.leet_1900_to_1999.leet_1926_nearest_exit_from_entrance_in_maze

import java.util.LinkedList
import java.util.Queue

/**
 * leetcode - https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
 *
 * Using BFS
 *
 * Stats
 * Runtime: 410 ms, faster than 51.65%
 * Memory Usage: 56.4 MB, less than 29.67%
 */
private fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
    fun isExit(row: Int, col: Int): Boolean {
        if (row == entrance[0] && col == entrance[1]) {
            return false
        }
        return row == 0 || col == 0 || row == maze.lastIndex || col == maze[0].lastIndex
    }

    fun getValidMoves(row: Int, col: Int): List<Pair<Int, Int>> {
        val result = mutableListOf<Pair<Int, Int>>()
        if (row > 0 && maze[row - 1][col] == '.') {
            result.add(Pair(row - 1, col))
        }
        if (col > 0 && maze[row][col - 1] == '.') {
            result.add(Pair(row, col - 1))
        }
        if (row < maze.lastIndex && maze[row + 1][col] == '.') {
            result.add(Pair(row + 1, col))
        }
        if (col < maze[0].lastIndex && maze[row][col + 1] == '.') {
            result.add(Pair(row, col + 1))
        }
        return result
    }

    var result = 0
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.addLast(Pair(entrance[0], entrance[1]))
    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val (row, col) = queue.removeFirst()
            if (isExit(row, col)) {
                return result
            }
            maze[row][col] = 'X'
            getValidMoves(row, col).forEach {
                queue.addLast(it)
            }
        }
        result++
    }
    return -1
}

/**
 * leetcode - https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
 *
 * Using BFS
 * Source - ChatGPT
 *
 * Stats
 * Runtime: 348 ms, faster than 81.32%
 * Memory Usage: 46.9 MB, less than 87.91%
 */
fun nearestExitUsingBFS(maze: Array<CharArray>, entrance: IntArray): Int {
    val m = maze.size
    val n = maze[0].size

    val directions = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.offer(Pair(entrance[0], entrance[1]))
    maze[entrance[0]][entrance[1]] = '+' // Marking entrance as visited

    var steps = 0

    while (queue.isNotEmpty()) {
        val size = queue.size

        for (i in 0 until size) {
            val current = queue.poll()

            for (dir in directions) {
                val newRow = current.first + dir[0]
                val newCol = current.second + dir[1]

                if (newRow in 0 until m && newCol in 0 until n && maze[newRow][newCol] == '.') {
                    if (newRow == 0 || newRow == m - 1 || newCol == 0 || newCol == n - 1) {
                        return steps + 1
                    }

                    queue.offer(Pair(newRow, newCol))
                    maze[newRow][newCol] = '+' // Marking cell as visited
                }
            }
        }

        steps++
    }

    return -1 // No exit found
}

private fun main() {

}
