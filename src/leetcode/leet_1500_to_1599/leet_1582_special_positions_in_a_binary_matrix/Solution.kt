package leetcode.leet_1500_to_1599.leet_1582_special_positions_in_a_binary_matrix

/**
 * leetcode - https://leetcode.com/problems/special-positions-in-a-binary-matrix/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 240 ms, faster than 100.00%
 * Memory Usage: 46.4 MB, less than 100.00%
 */
private fun numSpecial(mat: Array<IntArray>): Int {
    var result = 0
    mat.forEachIndexed { row, items ->
        items.forEachIndexed { col, item ->
            if (item == 1) {
                var flag = true
                for (i in 0..mat.lastIndex) {
                    if (i != row) {
                        if (mat[i][col] == 1) {
                            flag = false
                        }
                    }
                }
                for (i in 0..mat[0].lastIndex) {
                    if (i != col) {
                        if (mat[row][i] == 1) {
                            flag = false
                        }
                    }
                }
                if (flag) {
                    result++
                }
            }
        }
    }
    return result
}

private fun main() {

}
