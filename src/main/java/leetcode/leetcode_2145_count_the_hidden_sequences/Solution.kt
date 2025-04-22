package leetcode.leetcode_2145_count_the_hidden_sequences

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/count-the-hidden-sequences/description/?envType=daily-question&envId=2025-04-21
 *
 * Data Structure - Single Pointer
 * Algorithm - Pattern / Maths
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Amazon
 */
private fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
    var minValue = 0L
    var maxValue = 0L
    var current = 0L
    for (i in differences.indices) {
        current += differences[i]
        maxValue = max(maxValue, current)
        minValue = min(minValue, current)
    }
    return max(0L, upper - lower - maxValue + minValue + 1L).toInt()
}

private fun main() {

}
