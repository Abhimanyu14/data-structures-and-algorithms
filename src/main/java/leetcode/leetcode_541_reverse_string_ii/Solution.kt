package leetcode.leetcode_541_reverse_string_ii

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/reverse-string-ii/
 *
 * Using
 *
 * Stats
 *
 */
private fun reverseStr(s: String, k: Int): String {
    val a = s.toCharArray()
    var start = 0
    while (start < a.size) {
        var i = start
        var j = min(start + k - 1, a.size - 1)
        while (i < j) {
            val tmp = a[i]
            a[i++] = a[j]
            a[j--] = tmp
        }
        start += 2 * k
    }
    return String(a)
}

private fun main() {
    println(reverseStr("abcdefg", 2))
}
