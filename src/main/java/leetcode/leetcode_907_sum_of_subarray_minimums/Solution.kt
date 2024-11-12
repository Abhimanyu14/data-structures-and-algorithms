package leetcode.leetcode_907_sum_of_subarray_minimums

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/sum-of-subarray-minimums/
 *
 * TODO(Abhi) - To revisit
 *
 * Using brute force
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun sumSubarrayMins(arr: IntArray): Int {
    var result = 0
    val map = mutableMapOf<Pair<Int, Int>, Int>()
    arr.forEachIndexed { index, num ->
        map[Pair(index, index)] = num
        result += num
    }
    for (i in 2..arr.size) {
        for (j in 0..(arr.lastIndex - i + 1)) {
            val temp = min(map.getOrDefault(Pair(j, j + i - 2), 0), arr[j + i - 1])
            map[Pair(j, j + i - 1)] = temp
            result += temp
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/sum-of-subarray-minimums/
 *
 * Using brute force
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun sumSubarrayMinsUsingBruteForce(arr: IntArray): Int {
    var result = 0
    val map = mutableMapOf<Pair<Int, Int>, Int>()
    arr.forEachIndexed { index, num ->
        map[Pair(index, index)] = num
        result += num
    }
    for (i in 2..arr.size) {
        for (j in 0..(arr.lastIndex - i + 1)) {
            val temp = min(map.getOrDefault(Pair(j, j + i - 2), 0), arr[j + i - 1])
            map[Pair(j, j + i - 1)] = temp
            result += temp
        }
    }
    return result
}

private fun main() {

}
