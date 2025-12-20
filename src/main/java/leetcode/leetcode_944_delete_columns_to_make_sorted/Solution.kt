package leetcode.leetcode_944_delete_columns_to_make_sorted

/**
 * leetcode - https://leetcode.com/problems/delete-columns-to-make-sorted/?envType=daily-question&envId=2025-12-20
 *
 * Data Structure - Arrays
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(M * N)
 * Space - O(1)
 *
 * Companies - Amazon, Google
 */
private fun minDeletionSize(strs: Array<String>): Int {
    var result = 0
    for (i in 0..<strs[0].length) {
        for (j in 1..strs.lastIndex) {
            if (strs[j][i] < strs[j - 1][i]) {
                result++
                break
            }
        }
    }
    return result
}

private fun main() {
    println(minDeletionSize(arrayOf("cba", "daf", "ghi")))
}
