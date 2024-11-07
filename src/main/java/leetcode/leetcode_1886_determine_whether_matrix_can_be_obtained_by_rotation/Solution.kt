package leetcode.leetcode_1886_determine_whether_matrix_can_be_obtained_by_rotation

/**
 * leetcode - https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
 *
 * Using matrix position checks
 *
 * Stats
 * Runtime: 177 ms, faster than 33.33%
 * Memory Usage: 37.6 MB, less than 11.11%
 */
private fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
    var rotate0 = true
    var rotate90 = true
    var rotate180 = true
    var rotate270 = true
    for (i in mat.indices) {
        for (j in mat.indices) {
            if (rotate0 && target[i][j] != mat[i][j]) {
                rotate0 = false
            }
            if (rotate90 && target[mat.lastIndex - j][i] != mat[i][j]) {
                rotate90 = false
            }
            if (rotate180 && target[mat.lastIndex - i][mat.lastIndex - j] != mat[i][j]) {
                rotate180 = false
            }
            if (rotate270 && target[j][mat.lastIndex - i] != mat[i][j]) {
                rotate270 = false
            }
            if (!rotate0 && !rotate90 && !rotate180 && !rotate270) {
                return false
            }
        }
    }
    return rotate0 || rotate90 || rotate180 || rotate270
}

private fun main() {

}
