package leetcode.leetcode_2779_maximum_beauty_of_an_array_after_applying_operation

import java.util.PriorityQueue
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/
 *
 * Data Structure - Priority Queue
 * Algorithm - Line Sweep
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 458 ms, faster than 33.33%
 * Memory Usage: 77.3 MB, less than 25.00%
 *
 * Time - O(2 * N * log(N))
 * Space - O(N)
 */
private fun maximumBeautyUsingBinarySearch(nums: IntArray, k: Int): Int {
    var result = 0
    val sortedNums = nums.sorted()
    fun findUpperBound(current: Int): Int {
        var left = current
        var right = sortedNums.size
        while (left < right) {
            val mid = left + ((right - left) / 2)
            if (sortedNums[mid] > k * 2) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left - 1
    }

    for (i in sortedNums.indices) {
        result = max(result, findUpperBound(i) - i + 1)
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/
 *
 * Data Structure - Priority Queue (Can also be implemented using Array and Prefix Sum)
 * Algorithm - Line Sweep
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 667 ms, faster than 33.33%
 * Memory Usage: 63.9 MB, less than 50.00%
 *
 * Time - O(2 * N * log(N))
 * Space - O(2 * N)
 */
private fun maximumBeautyUsingLineSweep(nums: IntArray, k: Int): Int {
    var result = 0
    val priorityQueue = PriorityQueue<Pair<Int, Int>> { a, b ->
        if (a.first - b.first == 0) {
            a.second - b.second
        } else {
            a.first - b.first
        }
    }
    for (num in nums) {
        priorityQueue.offer(Pair(max(0, num - k), 1))
        priorityQueue.offer(Pair(num + k + 1, -1))
    }
    var currentMax = 0
    var current: Pair<Int, Int>
    while (priorityQueue.isNotEmpty()) {
        current = priorityQueue.poll()
        currentMax += current.second
        result = max(result, currentMax)
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/
 *
 * Using sorting, sliding window
 *
 * Stats
 * Runtime: 797 ms, faster than 25.00%
 * Memory Usage: 80.1 MB, less than 25.00%
 */
private fun maximumBeautyUsingSlidingWindow(nums: IntArray, k: Int): Int {
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
