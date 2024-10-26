package leetcode.leet_0_to_99.leet_54_spiral_matrix

/**
 * leetcode - https://leetcode.com/problems/spiral-matrix/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 * Runtime: 224 ms, faster than 54.93%
 * Memory Usage: 34 MB, less than 77.00%
 */
private fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val result = mutableListOf<Int>()
    var direction = 0
    val change = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
    var canContinue = true
    var x = 0
    var y = 0
    var nextX: Int
    var nextY: Int
    var directionChanged = false

    result.add(matrix[0][0])
    matrix[0][0] = Int.MAX_VALUE

    while (canContinue) {
        nextX = x + change[direction][0]
        nextY = y + change[direction][1]
        if (nextX < 0 || nextX >= matrix[0].size || nextY < 0 || nextY >= matrix.size || matrix[nextY][nextX] == Int.MAX_VALUE) {
            if (directionChanged) {
                canContinue = false
            } else {
                direction = (direction + 1) % 4
                directionChanged = true
            }
        } else {
            x = nextX
            y = nextY
            directionChanged = false
            result.add(matrix[y][x])
            matrix[y][x] = Int.MAX_VALUE
        }
    }
    return result
}

private fun main() {

}
