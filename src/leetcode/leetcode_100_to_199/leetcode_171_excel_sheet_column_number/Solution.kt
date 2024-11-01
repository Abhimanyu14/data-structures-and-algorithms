package leetcode.leetcode_100_to_199.leetcode_171_excel_sheet_column_number

import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/excel-sheet-column-number/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 178 ms, faster than 26.26%
 * Memory Usage: 36 MB, less than 31.31%
 */
private fun titleToNumber(columnTitle: String): Int {
    var result = 0
    for (i in columnTitle.indices) {
        result += (columnTitle[columnTitle.lastIndex - i] - 'A' + 1) * (26.0).pow(i).toInt()
    }
    return result
}

private fun main() {

}
