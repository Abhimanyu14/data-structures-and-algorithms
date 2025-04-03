package leetcode.leetcode_415_add_strings

/**
 * leetcode - https://leetcode.com/problems/add-strings/
 *
 * Data Structure - [StringBuilder]
 * Algorithm - Iteration
 *
 * String Builder methods - [insert]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 186 ms, faster than 71.60%
 * Memory Usage: 37.4 MB, less than 16.05%
 *
 * Time - O(M + N)
 * Space - O(M + N)
 *
 * Companies - Meta
 */
private fun addStrings(num1: String, num2: String): String {
    val result = StringBuilder()
    var index1 = num1.lastIndex
    var index2 = num2.lastIndex
    var carry = 0
    while (index1 >= 0 && index2 >= 0) {
        val sum = num1[index1].digitToInt() + num2[index2].digitToInt() + carry
        result.insert(0, "${sum % 10}")
        carry = sum / 10
        index1--
        index2--
    }
    while (index1 >= 0) {
        val sum = num1[index1].digitToInt() + carry
        result.insert(0, "${sum % 10}")
        carry = sum / 10
        index1--
    }
    while (index2 >= 0) {
        val sum = num2[index2].digitToInt() + carry
        result.insert(0, "${sum % 10}")
        carry = sum / 10
        index2--
    }
    if (carry != 0) {
        result.insert(0, "$carry")
    }
    return result.toString()
}

private fun main() {

}
