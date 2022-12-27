package leetcode.leet_0_to_99.leet_13_roman_to_integer

/**
 * leetcode - https://leetcode.com/problems/roman-to-integer/
 *
 * Using map
 *
 * Stats
 * Runtime: 254 ms, faster than 82.13%
 * Memory Usage: 36.7 MB, less than 83.39%
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
        if (prev < (map[it] ?: 0)) {
            result -= (prev * 2)
        }
        result += map[it] ?: 0
        prev = map[it] ?: 0
    }
    return result
}

private fun main() {

}
