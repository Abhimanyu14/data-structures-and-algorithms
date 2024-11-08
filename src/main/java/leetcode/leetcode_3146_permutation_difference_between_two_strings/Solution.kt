package leetcode.leetcode_3146_permutation_difference_between_two_strings

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/permutation-difference-between-two-strings/
 *
 * Using map
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 4 ms, faster than 75.00%
 * Memory Usage: 36.6 MB, less than 82.14%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun findPermutationDifference(s: String, t: String): Int {
    var result = 0
    val map = mutableMapOf<Char, Int>()
    s.forEachIndexed { index, char ->
        map[char] = index
    }
    t.forEachIndexed { index, char ->
        result += abs(index - map.getOrDefault(char, 0))
    }
    return result
}

private fun main() {

}
