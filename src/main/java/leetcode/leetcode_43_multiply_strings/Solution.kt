package leetcode.leetcode_43_multiply_strings

/**
 * leetcode - https://leetcode.com/problems/multiply-strings/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - String Parsing
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun multiply(num1: String, num2: String): String {
    var n1 = 0L
    var n2 = 0L
    var i = 0
    while (i <= num1.lastIndex) {
        n1 = (n1 * 10) + (num1[i] - '0')
        i++
    }
    i = 0
    while (i <= num2.lastIndex) {
        n2 = (n2 * 10) + (num2[i] - '0')
        i++
    }
    return (n1 * n2).toString()
}

private fun main() {

}
