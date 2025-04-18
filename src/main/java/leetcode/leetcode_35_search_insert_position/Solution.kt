package leetcode.leetcode_35_search_insert_position

/**
 * leetcode - https://leetcode.com/problems/search-insert-position/
 * https://leetcode.com/problems/search-insert-position/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
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
 * Companies - Google, Meta
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
