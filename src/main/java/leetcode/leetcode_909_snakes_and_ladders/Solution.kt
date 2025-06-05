package leetcode.leetcode_909_snakes_and_ladders

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/snakes-and-ladders/description/?envType=daily-question&envId=2025-05-31
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Grid
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N^2)
 * Space - O(N^2)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun snakesAndLadders(board: Array<IntArray>): Int {
    fun numToCoordinates(x: Int): Pair<Int, Int> {
        val row = board.lastIndex - ((x - 1) / board.size)
        val col = if ((board.size % 2 == 0 && row % 2 == 0) || ((board.size % 2 == 1 && row % 2 == 1))) {
            board.lastIndex - ((x - 1) % board.size)
        } else {
            (x - 1) % board.size
        }
        return Pair(row, col)
    }

    var result = -1
    val visited = BooleanArray(board.size * board.size)
    val queue = ArrayDeque<Int>()
    queue.addLast(1)
    while (queue.isNotEmpty()) {
        result++
        val queueSize = queue.size
        for (i in 0..<queueSize) {
            val current = queue.removeFirst()
            if (visited[current - 1]) {
                continue
            }
            visited[current - 1] = true
            if (current == board.size * board.size) {
                return result
            }
            var j = current + 1
            while (j <= min(current + 6, board.size * board.size)) {
                val (x, y) = numToCoordinates(j)
                if (board[x][y] != -1) {
                    if (!visited[board[x][y] - 1]) {
                        queue.addLast(board[x][y])
                    }
                } else {
                    if (!visited[j - 1]) {
                        queue.addLast(j)
                    }
                }
                j++
            }
        }
    }
    return -1
}

private fun main() {

}
