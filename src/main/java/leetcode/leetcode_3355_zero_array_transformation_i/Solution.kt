package leetcode.leetcode_3355_zero_array_transformation_i

import java.util.PriorityQueue
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/zero-array-transformation-i/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Array
 * Algorithm - PrefixSum
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 20 ms, faster than 46.48%
 * Memory Usage: 116.5 MB, less than 33.80%
 *
 * Time -
 * Space -
 */
private fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
    val prefixSum = IntArray(nums.size + 1)
    for ((start, end) in queries) {
        prefixSum[start]++
        prefixSum[end + 1]--
    }
    for (i in 1..prefixSum.lastIndex) {
        prefixSum[i] += prefixSum[i - 1]
    }
    for (i in nums.indices) {
        if (nums[i] > prefixSum[i]) {
            return false
        }
    }
    return true
}

/**
 * leetcode - https://leetcode.com/problems/zero-array-transformation-i/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Priority Queue
 * Algorithm - Sweep line
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 385 ms, faster than 24.44%
 * Memory Usage: 106.7 MB, less than 75.56%
 *
 * Time -
 * Space -
 */
private fun isZeroArrayUsingSweepLine(nums: IntArray, queries: Array<IntArray>): Boolean {
    val pq = PriorityQueue { a: Pair<Int, Int>, b: Pair<Int, Int> ->
        a.first - b.first
    }
    queries.forEach {
        pq.offer(Pair(it[0], 1))
        pq.offer(Pair(it[1] + 1, -1))
    }
    var index = 0
    var current = 0
    while (pq.isNotEmpty()) {
        val temp = pq.poll()
        while (index < temp.first) {
            if (nums[index] > current) {
                return false
            }
            index++
        }
        current += temp.second
    }
    while (index <= nums.lastIndex) {
        if (nums[index] > current) {
            return false
        }
        index++
    }
    return true
}

/**
 * leetcode - https://leetcode.com/problems/zero-array-transformation-i/
 *
 * Using Brute force
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun isZeroArrayUsingBruteForce(nums: IntArray, queries: Array<IntArray>): Boolean {
    queries.forEach {
        for (i in it[0]..it[1]) {
            nums[i] = max(0, nums[i] - 1)
        }
    }
    return nums.all { it == 0 }
}

private fun main() {

}
