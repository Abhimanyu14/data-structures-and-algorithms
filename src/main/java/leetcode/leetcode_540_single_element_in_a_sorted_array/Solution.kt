package leetcode.leetcode_540_single_element_in_a_sorted_array

/**
 * leetcode - https://leetcode.com/problems/single-element-in-a-sorted-array/
 *
 * Data Structure - Two Pointers
 * Algorithm - Binary Search
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(log(N))
 * Space - O(1)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun singleNonDuplicate(nums: IntArray): Int {
    var left = 0
    var right = nums.lastIndex
    fun isSingleElementToLeft(x: Int): Boolean {
        return (x == nums.lastIndex) ||
                ((x % 2 != 0) && (nums[x] != nums[x - 1])) ||
                ((x % 2 == 0) && (nums[x] != nums[x + 1]))
    }
    while (left < right) {
        val mid = left + (right - left) / 2
        if (isSingleElementToLeft(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return nums[left]
}

/**
 * leetcode - https://leetcode.com/problems/single-element-in-a-sorted-array/
 *
 * Using binary search - optimized
 *
 * Stats
 * Runtime: 290 ms, faster than 77.27%
 * Memory Usage: 45.7 MB, less than 54.55%
 */
private fun singleNonDuplicateUsingBinarySearchSimplified(nums: IntArray): Int {
    var low = 0
    var high = nums.lastIndex
    while (low < high) {
        var mid = low + (high - low) / 2
        if (mid % 2 == 1) {
            mid--
        }
        if (nums[mid] == nums[mid + 1]) {
            low = mid + 2
        } else {
            high = mid
        }
    }
    return nums[low]
}

/**
 * leetcode - https://leetcode.com/problems/single-element-in-a-sorted-array/
 *
 * Using binary search
 *
 * Stats
 * Runtime: 296 ms, faster than 72.73%
 * Memory Usage: 46.7 MB, less than 54.55%
 */
private fun singleNonDuplicateUsingBinarySearch(nums: IntArray): Int {
    var low = 0
    var high = nums.lastIndex
    var mid: Int
    while (low <= high) {
        mid = low + (high - low) / 2
        if (mid > 0 && nums[mid] == nums[mid - 1]) {
            if ((mid - low + 1) % 2 == 0) {
                low = mid + 1
            } else {
                high = mid
            }
        } else if (mid < nums.lastIndex && nums[mid] == nums[mid + 1]) {
            if ((mid - low) % 2 == 0) {
                low = mid
            } else {
                high = mid - 1
            }
        } else {
            return nums[mid]
        }
    }
    return -1
}

private fun main() {
    println(singleNonDuplicate(intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8)))
    println(singleNonDuplicate(intArrayOf(3, 3, 7, 7, 10, 11, 11)))
}
