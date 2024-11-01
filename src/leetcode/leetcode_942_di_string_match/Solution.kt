package leetcode.leetcode_942_di_string_match

/**
 * leetcode - https://leetcode.com/problems/di-string-match/
 *
 * Using greedy
 *
 * Stats
 * Runtime: 215 ms, faster than 93.75%
 * Memory Usage: 37.1 MB, less than 75.00%
 */
private fun diStringMatch(s: String): IntArray {
    var low = 0
    var high = s.length
    val result = IntArray(s.length + 1)
    for (i in s.indices) {
        if (s[i] == 'I') {
            result[i] = low++
        } else {
            result[i] = high--
        }
    }
    result[s.length] = low
    return result
}

private fun main() {
    println(diStringMatch("IDID").joinToString(", "))
}
