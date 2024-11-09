package leetcode.leetcode_2194_cells_in_a_range_on_an_excel_sheet

/**
 * leetcode - https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/description/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 2 ms, faster than 100.00%
 * Memory Usage: 38 MB, less than 30.00%
 *
 * Time -
 * Space -
 */
private fun cellsInRange(s: String): List<String> {
    val result = mutableListOf<String>()
    for (i in s[0]..s[3]) {
        for (j in s[1]..s[4]) {
            result.add("$i$j")
        }
    }
    return result
}

private fun main() {

}
