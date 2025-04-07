package leetcode.leetcode_658_find_k_closest_elements

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/find-k-closest-elements/
 *
 * Data Structure - NA
 * Algorithm - Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(log N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    fun getIndex(): Int {
        if (x < arr[0]) {
            return 0
        }
        if (x > arr.last()) {
            return arr.lastIndex
        }
        var left = 0
        var right = arr.lastIndex
        while (left < right) {
            val mid = left + (right - left) / 2
            if (arr[mid] >= x) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    val index = getIndex()
    var start = max(0, index - k)
    var end = min(arr.lastIndex, index + k)
    while (end - start >= k) {
        if (x - arr[start] <= arr[end] - x) {
            end--
        } else {
            start++
        }
    }
    val result = mutableListOf<Int>()
    for (i in start..end) {
        result.add(arr[i])
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/find-k-closest-elements/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Linear Search
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun findClosestElementsUsingLinearSearch(arr: IntArray, k: Int, x: Int): List<Int> {
    fun getIndex(): Int {
        if (x < arr[0]) {
            return 0
        }
        if (x > arr.last()) {
            return arr.lastIndex
        }
        for (i in arr.indices) {
            if (arr[i] >= x) {
                return i
            }
        }
        return -1
    }

    val index = getIndex()
    var start = max(0, index - k)
    var end = min(arr.lastIndex, index + k)
    while (end - start >= k) {
        if (x - arr[start] <= arr[end] - x) {
            end--
        } else {
            start++
        }
    }
    val result = mutableListOf<Int>()
    for (i in start..end) {
        result.add(arr[i])
    }
    return result
}

private fun main() {
}
