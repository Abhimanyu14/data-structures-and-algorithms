package leetcode.leetcode_1030_matrix_cells_in_distance_order

import java.util.LinkedList

/**
 * leetcode - https://leetcode.com/problems/matrix-cells-in-distance-order/
 *
 * Data Structure - Queue
 * Algorithm - BFS
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 18 ms, faster than 83.33%
 * Memory Usage: 44.8 MB, less than 16.67%
 *
 * Time -
 * Space -
 */
private fun allCellsDistOrder(rows: Int, cols: Int, rCenter: Int, cCenter: Int): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    val visited = Array(rows) { BooleanArray(cols) }
    val queue = LinkedList<IntArray>()
    queue.offer(intArrayOf(rCenter, cCenter))
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (!visited[current[0]][current[1]]) {
            visited[current[0]][current[1]] = true
            result.add(current)
            if (current[0] > 0) {
                queue.offer(intArrayOf(current[0] - 1, current[1]))
            }
            if (current[1] > 0) {
                queue.offer(intArrayOf(current[0], current[1] - 1))
            }
            if (current[0] < rows - 1) {
                queue.offer(intArrayOf(current[0] + 1, current[1]))
            }
            if (current[1] < cols - 1) {
                queue.offer(intArrayOf(current[0], current[1] + 1))
            }
        }
    }
    return result.toTypedArray()
}

private fun main() {

}
