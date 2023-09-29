package leetcode_discussions.google.table_divider

import kotlin.math.ceil

/**
 * leetcode - https://leetcode.com/discuss/interview-question/1423422/Google-or-phone-screen/1061613
 *
 * Description - We are given two texts - text1 and text2 to place in a 1 x 2 table.
 * We need to find where we can place the divider to get the minimum height.
 *
 * TODO(Abhi) - To complete
 *
 * Using
 */
private fun getDividerPosition(t1: String, t2: String, tableWidth: Int): Int {
    fun getNumberOfLines(s: String, width: Int): Int {
        return ceil(s.length.toDouble() / width).toInt()
    }

    var separator = tableWidth / 2
    val t1Lines = getNumberOfLines(t1, separator)
    val t2Lines = getNumberOfLines(t2, tableWidth - separator)
    if (t1Lines == t2Lines) {
        return separator
    }
    var low: Int
    var high: Int
    if (t1Lines > t2Lines) {
        low = separator
        high = tableWidth
    } else {
        low = 0
        high = separator
    }

    return separator
}

private fun main() {
    getDividerPosition("AB", "CDEFGH", 8)
    getDividerPosition("ABCD", "CDEFGHIJ", 10)
}
