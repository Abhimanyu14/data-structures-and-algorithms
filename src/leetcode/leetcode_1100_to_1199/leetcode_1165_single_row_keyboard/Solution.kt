package leetcode.leetcode_1100_to_1199.leetcode_1165_single_row_keyboard

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/single-row-keyboard/
 *
 * Using string indexOf()
 *
 * Stats
 * Runtime: 204 ms, faster than 78.75%
 * Memory Usage: 35.9 MB, less than 75.00%
 */
private fun calculateTime(keyboard: String, word: String): Int {
    var pointer = 0
    var result = 0
    var index: Int
    for (c in word) {
        index = keyboard.indexOf(c)
        result += abs(pointer - index)
        pointer = index
    }
    return result
}

private fun main() {

}
