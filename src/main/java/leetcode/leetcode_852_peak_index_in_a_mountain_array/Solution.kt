package leetcode.leetcode_852_peak_index_in_a_mountain_array

/**
 * leetcode - https://leetcode.com/problems/peak-index-in-a-mountain-array/description/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=MEDIUM
 *
 * Data Structure - Two Pointers
 * Algorithm - Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 16 ms, faster than 24.14%
 * Memory Usage: 52.5 MB, less than 44.44%
 *
 * Time - O(N * log(N))
 * Space - O(1)
 */
private fun peakIndexInMountainArray(arr: IntArray): Int {
    var left = 0
    var right = arr.lastIndex
    var mid: Int
    while (left < right) {
        mid = left + ((right - left) / 2)
        if (arr[mid] > arr[mid + 1]) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

private fun main() {

}
