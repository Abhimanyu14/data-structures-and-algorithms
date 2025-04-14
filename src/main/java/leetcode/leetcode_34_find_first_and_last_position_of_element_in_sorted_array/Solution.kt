package leetcode.leetcode_34_find_first_and_last_position_of_element_in_sorted_array

/**
 * leetcode - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Two Pointers
 * Algorithm - Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 332 ms, faster than 57.04%
 * Memory Usage: 45.7 MB, less than 10.83%
 *
 * Time - O(log(N))
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun searchRange(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()) {
        return intArrayOf(-1, -1)
    }
    fun getFirstIndex( x: Int, start: Int = 0, end: Int = nums.lastIndex): Int {
        var left = start
        var right = end
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] >= x) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }
    val firstPos = getFirstIndex(target)
    if (nums[firstPos] != target) {
        return intArrayOf(-1, -1)
    }
    return intArrayOf(firstPos, getFirstIndex(target + 1, firstPos, nums.lastIndex + 1) - 1)
}

/**
 * leetcode - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Using linear search
 *
 * Stats
 * Runtime: 239 ms, faster than 71.84%
 * Memory Usage: 40 MB, less than 73.65%
 */
private fun searchRangeUsingLinearSearch(nums: IntArray, target: Int): IntArray {
    var first = -1
    var last = -1
    for (i in nums.indices) {
        if (nums[i] == target) {
            first = i
            break
        }
    }
    if (first != -1) {
        last = first
        while (last < nums.lastIndex && nums[last + 1] == target) {
            last++
        }
    }
    return intArrayOf(first, last)
}

private fun main() {
    println(searchRange(intArrayOf(5, 7, 7, 8, 8, 8), 8).joinToString(", "))
    println(searchRange(intArrayOf(2, 2), 2).joinToString(", "))
}
