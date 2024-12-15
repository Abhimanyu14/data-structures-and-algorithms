package leetcode.leetcode_13_roman_to_integer

/**
 * leetcode - https://leetcode.com/problems/roman-to-integer/
 * https://leetcode.com/problems/roman-to-integer/description/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=EASY
 *
 * Data Structure - Map
 * Algorithm - Hashing and Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 254 ms, faster than 82.13%
 * Memory Usage: 36.7 MB, less than 83.39%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun romanToInt(s: String): Int {
    val map = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
    var result = 0
    var prev = Integer.MAX_VALUE
    s.forEach {
        if (prev < (map.getOrDefault(it, 0))) {
            result -= (prev * 2)
        }
        result += map.getOrDefault(it, 0)
        prev = map.getOrDefault(it, 0)
    }
    return result
}

private fun main() {

}
