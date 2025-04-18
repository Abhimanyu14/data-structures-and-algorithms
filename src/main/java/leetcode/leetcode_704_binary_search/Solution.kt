package leetcode.leetcode_704_binary_search

/**
 * leetcode - https://leetcode.com/problems/binary-search/
 *
 * Data Structure - Two Pointers
 * Algorithm - Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(log(N))
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size
    while (left < right) {
        val mid = left + (right - left) / 2
        if (nums[mid] >= target) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return if (left <= nums.lastIndex && nums[left] == target) {
        left
    } else {
        -1
    }
}

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

private fun main() {
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
    println(search(intArrayOf(-1, 0, 5), -1))
}
