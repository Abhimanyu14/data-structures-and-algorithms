package leetcode.leetcode_164_maximum_gap

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-gap/
 *
 * Data Structure - NA
 * Algorithm - Linear Search
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 289 ms, faster than 6.06%
 * Memory Usage: 61.3 MB, less than 9.09%
 *
 * Time - O(N * log(N))
 * Space - O(N)
 */
private fun maximumGap(nums: IntArray): Int {
    if (nums.size == 1) {
        return 0
    }
    val sorted = nums.sorted()
    var result = sorted[1] - sorted[0]
    for (i in 2..sorted.lastIndex) {
        result = max(result, sorted[i] - sorted[i - 1])
    }
    return result
}

private fun main() {

}
