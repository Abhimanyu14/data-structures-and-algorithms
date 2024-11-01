package leetcode.leetcode_344_reverse_string

/**
 * leetcode - https://leetcode.com/problems/reverse-string/
 *
 * Stats
 * Runtime: 244 ms, faster than 66.89%
 * Memory Usage: 47.9 MB, less than 72.79%
 */
fun reverseString(s: CharArray): Unit {
    s.reverse()
}

private fun main() {
    val input1 = charArrayOf('h', 'e', 'l', 'l', 'o')
    val input2 = charArrayOf('H', 'a', 'n', 'n', 'a', 'h')
    reverseString(input1)
    reverseString(input2)
    println(input1)
    println(input2)
}
