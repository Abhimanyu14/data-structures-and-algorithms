package leetcode.leetcode_168_excel_sheet_column_title

/**
 * leetcode - https://leetcode.com/problems/excel-sheet-column-title/
 *
 * Using StringBuilder and loops
 *
 * Stats
 * Runtime: 113 ms, faster than 95.71%
 * Memory Usage: 33 MB, less than 80.00%
 */
private fun convertToTitle(columnNumber: Int): String {
    val result = StringBuilder()
    var num = columnNumber - 1
    while (num >= 26) {
        result.insert(0, 'A' + (num % 26))
        num = (num / 26) - 1
    }
    result.insert(0, 'A' + num)
    return result.toString()
}

private fun main() {

}
