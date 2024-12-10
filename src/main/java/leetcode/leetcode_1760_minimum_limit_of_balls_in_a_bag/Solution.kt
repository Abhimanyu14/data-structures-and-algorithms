package leetcode.leetcode_1760_minimum_limit_of_balls_in_a_bag

/**
 * leetcode - https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - Two Pointers
 * Algorithm - Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 * Runtime: 52 ms, faster than 60.27%
 * Memory Usage: 57.1 MB, less than 79.45%
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun minimumSize(nums: IntArray, maxOperations: Int): Int {
    fun isPossible(x: Int): Boolean {
        var count = 0
        nums.forEach {
            count += (it / x) - 1
            if (it % x != 0) {
                count++
            }
            if (count > maxOperations) {
                return false
            }
        }
        return count <= maxOperations
    }

    var left = 1
    var right = nums.max()
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (isPossible(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

private fun main() {

}
