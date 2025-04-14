package leetcode.leetcode_1534_count_good_triplets

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/count-good-triplets/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 174 ms, faster than 44.44%
 * Memory Usage: 37.2 MB, less than 11.11%
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, Microsoft
 */
private fun countGoodTripletsUsingBruteForce(arr: IntArray, a: Int, b: Int, c: Int): Int {
    var result = 0
    for (i in 0..(arr.lastIndex - 2)) {
        for (j in (i + 1)..<arr.lastIndex) {
            if (abs(arr[i] - arr[j]) <= a) {
                for (k in (j + 1)..arr.lastIndex) {
                    if (abs(arr[j] - arr[k]) <= b && abs(arr[i] - arr[k]) <= c) {
                        result++
                    }
                }
            }
        }
    }
    return result
}

private fun main() {

}
