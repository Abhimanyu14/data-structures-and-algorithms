package leetcode.leetcode_0_to_99.leetcode_59_merge_intervals

/**
 * leetcode - https://leetcode.com/problems/merge-intervals/
 *
 * Stats
 */
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val result = intervals.sortedBy { it[0] }.toMutableList()
    var i = 0
    while (i < result.size - 1) {
        if (result[i][1] >= result[i + 1][0]) {
            result[i] = intArrayOf(result[i][0], maxOf(result[i][1], result[i + 1][1]))
            result.removeAt(i + 1)
        } else {
            i++
        }
    }
    return result.toTypedArray()
}

private fun main() {
    val input1 = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
    val input2 = arrayOf(intArrayOf(1, 4), intArrayOf(4, 5))
    println(merge(input1).joinToString(" ") { it.joinToString(",") })
    println(merge(input2).joinToString(" ") { it.joinToString(",") })
}
