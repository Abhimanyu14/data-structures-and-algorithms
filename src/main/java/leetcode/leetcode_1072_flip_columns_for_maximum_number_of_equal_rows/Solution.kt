package leetcode.leetcode_1072_flip_columns_for_maximum_number_of_equal_rows

/**
 * leetcode - https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/
 *
 * Using StringBuilder and map
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 42 ms, faster than 100.00%
 * Memory Usage: 52.8 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
    val counter = mutableMapOf<String, Int>()
    val sb = StringBuilder()
    var shouldFlip: Boolean
    matrix.forEach { row ->
        shouldFlip = row[0] == 0
        sb.clear()
        row.forEach { num ->
            if (shouldFlip) {
                if (num == 0) {
                    sb.append(1)
                } else {
                    sb.append(0)
                }
            } else {
                sb.append(num)
            }
        }
        val string = sb.toString()
        counter[string] = counter.getOrDefault(string, 0) + 1
    }
    return counter.values.max()
}

private fun main() {

}
