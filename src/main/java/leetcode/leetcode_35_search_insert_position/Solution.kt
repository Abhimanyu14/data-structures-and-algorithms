package leetcode.leetcode_35_search_insert_position

/**
 * leetcode - https://leetcode.com/problems/search-insert-position/
 * https://leetcode.com/problems/search-insert-position/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Using binary search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Stats
 * Runtime: 171 ms, faster than 55.18%
 * Memory Usage: 37.2 MB, less than 72.35%
 */
private fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (nums[mid] >= target) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

private fun main() {
    println(searchInsert(intArrayOf(1, 3, 5, 6), 5))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 2))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 7))
}
