package leetcode.leetcode_2379_minimum_recolors_to_get_k_consecutive_black_blocks

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 *
 * Using sliding window
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 33.8 MB, less than 100.00%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun minimumRecolors(blocks: String, k: Int): Int {
    var result = k
    var current = 0
    var index = 0
    while (index < k) {
        if (blocks[index] == 'W') {
            current++
        }
        index++
    }
    result = min(result, current)
    while (index < blocks.length) {
        if (blocks[index] == 'W') {
            current++
        }
        if (blocks[index - k] == 'W') {
            current--
        }
        index++
        result = min(result, current)
    }
    return result
}

private fun main() {

}
