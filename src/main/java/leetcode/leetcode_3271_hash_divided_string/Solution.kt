package leetcode.leetcode_3271_hash_divided_string

/**
 * leetcode - https://leetcode.com/problems/hash-divided-string/description/
 *
 * Using StringBuilder, [step] and iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 4 ms, faster than 100.00%
 * Memory Usage: 37.3 MB, less than 85.71%
 *
 * Time -
 * Space -
 */
private fun stringHash(s: String, k: Int): String {
    val result = StringBuilder()
    var current: Int
    for (i in s.indices step k) {
        current = 0
        repeat(k) {
            current += s[i + it] - 'a'
        }
        current %= 26
        result.append('a' + current)
    }
    return result.toString()
}

private fun main() {

}
