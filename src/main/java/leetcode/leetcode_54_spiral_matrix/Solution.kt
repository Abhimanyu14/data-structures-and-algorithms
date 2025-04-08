package leetcode.leetcode_54_spiral_matrix

/**
 * leetcode - https://leetcode.com/problems/spiral-matrix/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 */

/**
 * leetcode - https://leetcode.com/problems/spiral-matrix/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 224 ms, faster than 54.93%
 * Memory Usage: 34 MB, less than 77.00%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val result = mutableListOf<Int>()
    val visited = Array(matrix.size) {
        BooleanArray(matrix[0].size)
    }
    val directions = arrayOf(Pair(0, 1), Pair(-1, 0), Pair(0, -1), Pair(1, 0))
    var currentPosition: Pair<Int, Int>? = Pair(0, 0)
    var currentDirection = 0

    fun isValidPosition(point: Pair<Int, Int>): Boolean {
        return !(point.first < 0 || point.second < 0 || point.first > matrix.lastIndex || point.second > matrix[0].lastIndex || visited[point.first][point.second])
    }

    fun getNext() {
        repeat(4) {
            val nextPosition = Pair(
                (currentPosition?.first ?: 0) + directions[currentDirection].first,
                (currentPosition?.second ?: 0) + directions[currentDirection].second
            )
            if (isValidPosition(nextPosition)) {
                currentPosition = nextPosition
                return
            }
            currentDirection = (currentDirection + 1) % 4
        }
        currentPosition = null
    }
    while (currentPosition != null) {
        result.add(matrix[currentPosition?.first ?: 0][currentPosition?.second ?: 0])
        visited[currentPosition?.first ?: 0][currentPosition?.second ?: 0] = true
        getNext()
    }
    return result
}

private fun main() {

}
