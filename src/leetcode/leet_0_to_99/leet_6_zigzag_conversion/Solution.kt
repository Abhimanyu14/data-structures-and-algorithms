package leetcode.leet_0_to_99.leet_6_zigzag_conversion

/**
 * leetcode - https://leetcode.com/problems/zigzag-conversion/
 *
 * Using string builders
 *
 * Stats
 * Runtime: 212 ms, faster than 80.68%
 * Memory Usage: 37.3 MB, less than 79.46%
 */
private fun convert(s: String, numRows: Int): String {
    if (numRows == 1) {
        return s
    }
    var increase = true
    var row = 0
    val rowStrings : List<StringBuilder> = List(numRows) {
        StringBuilder()
    }
    s.forEachIndexed { index, char ->
        rowStrings[row].append(char)
        if (increase) {
            if (row == numRows - 1) {
                increase = false
                row--
            } else {
                row++
            }
        } else {
            if (row == 0) {
                increase = true
                row++
            } else {
                row--
            }
        }
    }
    val result = StringBuilder()
    rowStrings.forEach {
        result.append(it.toString())
    }
    return result.toString()
}

private fun main() {

}
