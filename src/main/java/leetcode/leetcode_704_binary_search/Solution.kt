package leetcode.leetcode_704_binary_search

/**
 * leetcode - https://leetcode.com/problems/binary-search/
 *
 * Using binary search, recursion
 * Conditions: Number must be sorted
 *
 * Stats
 * Runtime: 557 ms, faster than 26.73%
 * Memory Usage: 66.9 MB, less than 13.15%
 *
 * Companies - Meta
 */
private fun searchUsingRecursion(nums: IntArray, target: Int): Int {
    // Leetcode does not support trailing commas
    return binarySearch(
        low = 0,
        mid = ((nums.lastIndex) / 2),
        high = nums.lastIndex,
        nums = nums,
        target = target,
    )
}

private fun binarySearch(low: Int, mid: Int, high: Int, nums: IntArray, target: Int): Int {
    if (nums[mid] == target) return mid
    if (low > high) return -1
    return if (target > nums[mid]) {
        binarySearch(
            low = mid + 1,
            mid = ((high + (mid + 1)) / 2),
            high = high,
            nums = nums,
            target = target,
        )
    } else {
        binarySearch(
            low = low,
            mid = ((mid - 1 + low) / 2),
            high = mid - 1,
            nums = nums,
            target = target,
        )
    }
}

/**
 * Using binary search, loops
 * Conditions: Number must be sorted
 *
 * Stats
 * Runtime: 299 ms, faster than 86.93%
 * Memory Usage: 39.3 MB, less than 85.31%
 */
private fun search(nums: IntArray, target: Int): Int {
    var low = 0
    var mid = nums.lastIndex / 2
    var high = nums.lastIndex
    if (nums[mid] == target) return mid
    while (low <= high) {
        if (nums[mid] == target) return mid
        if (target > nums[mid]) {
            low = mid + 1
            mid = ((high + mid + 1) / 2)
        } else {
            high = mid - 1
            mid = ((mid - 1 + low) / 2)
        }
    }
    return -1
}

private fun main() {
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
    println(search(intArrayOf(-1, 0, 5), -1))
}
