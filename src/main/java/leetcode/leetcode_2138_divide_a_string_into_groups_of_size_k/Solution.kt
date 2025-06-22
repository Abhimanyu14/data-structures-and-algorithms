package leetcode.leetcode_2138_divide_a_string_into_groups_of_size_k

import kotlin.math.ceil

/**
 * leetcode - https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/description/?envType=daily-question&envId=2025-06-22
 *
 * Data Structure - [StringBuilder]
 * Algorithm -
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun divideString(s: String, k: Int, fill: Char): Array<String> {
    val result = Array(ceil(s.length.toDouble() / k).toInt()) { "" }
    var index = 0
    while (index * k <= s.lastIndex) {
        val current = StringBuilder()
        var i = 0
        while (i < k && (index * k) + i <= s.lastIndex) {
            current.append(s[(index * k) + i])
            i++
        }
        while (current.length < k) {
            current.append(fill)
        }
        result[index] = current.toString()
        index++
    }
    return result
}

private fun main() {

}
