package leetcode.leetcode_1534_count_good_triplets

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/count-good-triplets/
 *
 * Using
 *
 * Stats
 * Runtime: 174 ms, faster than 44.44%
 * Memory Usage: 37.2 MB, less than 11.11%
 */
private fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
    var result = 0
    for (i in 0..arr.lastIndex) {
        for (j in (i + 1)..arr.lastIndex) {
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
