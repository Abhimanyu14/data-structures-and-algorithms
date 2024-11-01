package leetcode.leetcode_1800_to_1899.leetcode_1846_maximum_element_after_decreasing_and_rearranging

/**
 * leetcode - https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
 *
 * Using sorting
 *
 * Stats
 * Runtime: 396 ms, faster than 100.00%
 * Memory Usage: 57.7 MB, less than 100.00%
 */
private fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
    var result = 0
    arr.sorted().forEach {
        if (it > result) {
            result++
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
 *
 * Using sorting
 *
 * Stats
 * Runtime: 386 ms, faster than 100.00%
 * Memory Usage: 58.5 MB, less than 100.00%
 */
private fun maximumElementAfterDecrementingAndRearrangingUsingSort(arr: IntArray): Int {
    var result = 0
    val sorted = arr.sorted()
    var index = sorted.lastIndex
    while (index >= 0 && sorted[index] > sorted.size) {
        result++
        index--
    }
    var current = sorted.size
    while (index >= 0 && current >= 1) {
        if (sorted[index] >= current) {
            current--
        } else {
            current = sorted[index] - 1
        }
        result++
        index--
    }
    return result
}

private fun main() {

}
