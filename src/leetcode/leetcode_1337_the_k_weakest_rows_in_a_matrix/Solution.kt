package leetcode.leetcode_1337_the_k_weakest_rows_in_a_matrix

/**
 * leetcode - https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 *
 * Using functional programming
 *
 * Stats
 * Runtime: 187 ms, faster than 96.43%
 * Memory Usage: 38.5 MB, less than 92.86%
 */
private fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
    return (0 until mat.size) // mat.indices is not performant as this 😕
        .sortedWith(compareBy { mat[it].count { num -> num == 1 } })
        .take(k)
        .toIntArray()
}

private fun main() {
    
}
