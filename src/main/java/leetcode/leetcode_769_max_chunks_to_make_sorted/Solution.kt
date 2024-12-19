package leetcode.leetcode_769_max_chunks_to_make_sorted

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/max-chunks-to-make-sorted/?envType=daily-question&envId=2024-12-19
 *
 * Data Structure - NA
 * Algorithm - Max Element
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34.8 MB, less than 37.50%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun maxChunksToSorted(arr: IntArray): Int {
    var result = 0
    var currentMax = 0
    for (i in arr.indices) {
        currentMax = max(currentMax, arr[i])
        if (currentMax == i) {
            result++
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/max-chunks-to-make-sorted/?envType=daily-question&envId=2024-12-19
 *
 * Data Structure - NA
 * Algorithm - Sum of first N numbers and Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34.7 MB, less than 37.50%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun maxChunksToSortedUsingSumOfFirstXNumbers(arr: IntArray): Int {
    var result = 0
    var current = 0
    for (i in arr.indices) {
        current += arr[i]
        if ((i * (i + 1)) == (current * 2)) {
            result++
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/max-chunks-to-make-sorted/?envType=daily-question&envId=2024-12-19
 *
 * Data Structure - Set
 * Algorithm - Iteration and Hashing
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 1 ms, faster than 25.00%
 * Memory Usage: 34.4 MB, less than 75.00%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun maxChunksToSortedUsingSet(arr: IntArray): Int {
    var result = 0
    val set = mutableSetOf<Int>()
    var current = 0
    for (i in arr.indices) {
        set.add(arr[i])
        while (set.contains(current)) {
            current++
        }
        if (set.size == current) {
            result++
        }
    }
    return result
}

private fun main() {

}
