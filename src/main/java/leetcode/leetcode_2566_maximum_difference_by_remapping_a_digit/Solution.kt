package leetcode.leetcode_2566_maximum_difference_by_remapping_a_digit

/**
 * leetcode - https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/?envType=daily-question&envId=2025-06-14
 *
 * Data Structure - [CharArray]
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies -
 */
private fun minMaxDifference(num: Int): Int {
    val numString = num.toString()
    var maxValue = 0
    var minvalue = 0
    var maxDigit: Char? = null
    val minDigitChar = numString[0]
    for (char in numString) {
        if (maxDigit == null && char != '9') {
            maxDigit = char
        }
        maxValue = if (maxDigit != null && char != maxDigit) {
            (maxValue * 10) + char.digitToInt()
        } else {
            (maxValue * 10) + 9
        }
        minvalue = if (char != minDigitChar) {
            (minvalue * 10) + char.digitToInt()
        } else {
            (minvalue * 10)
        }
    }
    return maxValue - minvalue
}

private fun main() {

}
