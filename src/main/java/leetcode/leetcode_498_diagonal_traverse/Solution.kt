package leetcode.leetcode_498_diagonal_traverse

/**
 * leetcode - https://leetcode.com/problems/diagonal-traverse/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [IntArray]
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(m * n)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
    val result = IntArray(mat.size * mat[0].size)
    var x = 0
    var y = 0
    var isMovingUp = true
    for (i in 0..result.lastIndex) {
        result[i] = mat[x][y]
        if (isMovingUp) {
            if (x > 0 && y < mat[0].lastIndex) { // move top right
                x--
                y++
            } else {
                isMovingUp = false
                if (y < mat[0].lastIndex) { // move right
                    y++
                } else { // move bottom
                    x++
                }
            }
        } else {
            if (x < mat.lastIndex && y > 0) { // move bottom left
                x++
                y--
            } else {
                isMovingUp = true
                if (x < mat.lastIndex) { // move bottom
                    x++
                } else { // move right
                    y++
                }
            }
        }
    }
    return result
}

private fun main() {

}
