package leetcode.leetcode_240_search_a_2d_matrix_ii

/**
 * leetcode - https://leetcode.com/problems/search-a-2d-matrix-ii/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Linear Search
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * M - matrix.size
 * N - matrix[0].size
 * Time - O(M * N)
 * Space - O(1)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */

/**
 * leetcode - https://leetcode.com/problems/search-a-2d-matrix-ii/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 *
 * Data Structure - NA
 * Algorithm - Linear Search
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * M - matrix.size
 * N - matrix[0].size
 * Time - O(M * N)
 * Space - O(1)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun searchMatrixUsingLinearSearch(matrix: Array<IntArray>, target: Int): Boolean {
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] == target) {
                return true
            } else if (matrix[i][j] > target) {
                break
            }
        }
    }
    return false
}

private fun main() {

}
