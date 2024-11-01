package leetcode.leetcode_900_to_999.leetcode_944_delete_columns_to_make_sorted

/**
 * leetcode - https://leetcode.com/problems/delete-columns-to-make-sorted/
 *
 * Using brute force
 *
 * Stats
 * Runtime: 432 ms, faster than 31.25%
 * Memory Usage: 50.7 MB, less than 18.75%
 */
private fun minDeletionSize(strs: Array<String>): Int {
    var result = 0
    for (i in 0 until strs[0].length) {
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
