package leetcode.leetcode_2779_maximum_beauty_of_an_array_after_applying_operation

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/
 *
 * Using sorting, sliding window
 *
 * Stats
 * Runtime: 797 ms, faster than 25.00%
 * Memory Usage: 80.1 MB, less than 25.00%
 */
private fun maximumBeauty(nums: IntArray, k: Int): Int {
    val sorted = nums.sorted()
    var start = 0
    var end = 0
    var result = 0
    while (end < sorted.size) {
        if (sorted[end] - sorted[start] <= 2 * k) {
            result = max(result, end - start + 1)
        } else {
            while (start < end && sorted[end] > sorted[start] + (2 * k)) {
                start++
            }
        }
        end++
    }
    return result
}

private fun main() {

}
