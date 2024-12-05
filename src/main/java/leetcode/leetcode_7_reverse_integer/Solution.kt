package leetcode.leetcode_7_reverse_integer

/**
 * leetcode - https://leetcode.com/problems/reverse-integer/
 *
 * Data Structure - NA
 * Algorithm - Digit Extraction and Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 230 ms, faster than 76.67%
 * Memory Usage: 34 MB, less than 77.94%
 *
 * Time -
 * Space -
 */
private fun reverse(x: Int): Int {
    var reversed = 0
    var temp = x
    while (temp != 0) {
        if ((reversed > Integer.MAX_VALUE / 10) ||
            (reversed == Integer.MAX_VALUE / 10 && temp % 10 > 7) ||
            (reversed < Integer.MIN_VALUE / 10) ||
            (reversed == Integer.MAX_VALUE / 10 && temp % 10 < -8)
        ) {
            return 0
        }
        reversed = reversed * 10 + temp % 10
        temp /= 10
    }
    return reversed
}

private fun main() {
    println(Integer.MAX_VALUE)
    println(Integer.MIN_VALUE)
    println(reverse(1534236469))
    println(reverse(0))
    println(reverse(-123))
    println(reverse(123))
    println(reverse(120))
}
