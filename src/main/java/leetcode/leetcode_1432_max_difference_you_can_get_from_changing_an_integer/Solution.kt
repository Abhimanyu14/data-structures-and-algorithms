package leetcode.leetcode_1432_max_difference_you_can_get_from_changing_an_integer

/**
 * leetcode - https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/?envType=daily-question&envId=2025-06-15
 *
 * Data Structure - [String]
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies -
 */
private fun maxDiff(num: Int): Int {
    val numString = num.toString()
    var maxValue = 0
    var minValue = 0
    var maxDigit: Char? = null
    var minDigit: Char? = null
    val minReplacement = if (numString[0] == '1') {
        0
    } else {
        minDigit = numString[0]
        1
    }
    for (i in numString.indices) {
        if (maxDigit == null && numString[i] != '9') {
            maxDigit = numString[i]
        }
        if (minDigit == null && i > 0 && numString[i] != numString[0] && numString[i] != '0') {
            minDigit = numString[i]
        }
        maxValue = if (numString[i] == maxDigit) {
            (maxValue * 10) + 9
        } else {
            (maxValue * 10) + numString[i].digitToInt()
        }
        minValue = if (numString[i] == minDigit) {
            (minValue * 10) + minReplacement
        } else {
            (minValue * 10) + numString[i].digitToInt()
        }
    }
    return maxValue - minValue
}

private fun main() {

}
