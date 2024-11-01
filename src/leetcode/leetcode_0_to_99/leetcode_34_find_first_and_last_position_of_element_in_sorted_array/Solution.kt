package leetcode.leetcode_0_to_99.leetcode_34_find_first_and_last_position_of_element_in_sorted_array

/**
 * leetcode - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Using binary search
 *
 * Stats
 * Runtime: 332 ms, faster than 57.04%
 * Memory Usage: 45.7 MB, less than 10.83%
 */
private fun searchRange(nums: IntArray, target: Int): IntArray {
    var low = 0
    var high = nums.lastIndex
    var mid: Int
    while (low <= high) {
        mid = low + (high - low) / 2
        if (nums[mid] == target) {
            return intArrayOf(findFirst(nums, target, high, low), findLast(nums, target, high, low))
        } else if (nums[mid] < target) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return intArrayOf(-1, -1)
}

private fun findFirst(nums: IntArray, target: Int, high: Int, low: Int): Int {
    var highCopy = high
    var lowCopy = low
    var mid = lowCopy + (highCopy - lowCopy) / 2
    while (lowCopy < highCopy) {
        mid = lowCopy + (highCopy - lowCopy) / 2
        if (nums[mid] < target) {
            lowCopy = mid + 1
        } else if (mid > 0 && nums[mid - 1] == target) {
            highCopy = mid
        } else {
            break
        }
    }
    return mid
}

private fun findLast(nums: IntArray, target: Int, high: Int, low: Int): Int {
    var highCopy = high
    var lowCopy = low
    var mid = lowCopy + (highCopy - lowCopy) / 2
    while (lowCopy <= highCopy) {
        mid = lowCopy + (highCopy - lowCopy) / 2
        if (nums[mid] > target) {
            highCopy = mid - 1
        } else if (mid < nums.lastIndex && nums[mid + 1] == target) {
            lowCopy = mid + 1
        } else {
            break
        }
    }
    return mid
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
