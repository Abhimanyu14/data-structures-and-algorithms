package leetcode.leetcode_13_roman_to_integer

/**
 * leetcode - https://leetcode.com/problems/roman-to-integer/
 * https://leetcode.com/problems/roman-to-integer/description/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=EASY
 *
 * Data Structure - [Map]
 * Algorithm - Hashing and Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 17 ms, faster than 33.10%
 * Memory Usage: 47.32 MB, less than 10.28%
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Google, Meta
 */
private fun romanToInt(s: String): Int {
    val map = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000,
    )
    var result = 0
    var prev = map[s[0]] ?: 0
    for (i in 1..s.lastIndex) {
        val current = map[s[i]] ?: 0
        if (current > prev) {
            result -= prev
        } else {
            result += prev
        }
        prev = current
    }
    result += prev
    return result
}

private fun main() {

}
