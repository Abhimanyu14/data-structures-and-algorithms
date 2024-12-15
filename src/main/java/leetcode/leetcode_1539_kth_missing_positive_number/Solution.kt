package leetcode.leetcode_1539_kth_missing_positive_number

/**
 * leetcode - https://leetcode.com/problems/kth-missing-positive-number/
 * https://leetcode.com/problems/kth-missing-positive-number/description/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=EASY
 *
 * Data Structure - Two Pointers
 * Algorithm - Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 37.6 MB, less than 34.83%
 *
 * Time - O(log (N))
 * Space - O(1)
 */
private fun findKthPositive(arr: IntArray, k: Int): Int {
    if (arr[0] > k) {
        return k
    }
    var left = 0
    var right = arr.size
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (arr[mid] - (mid + 1) >= k) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return k + left
}

/**
 * leetcode - https://leetcode.com/problems/kth-missing-positive-number/
 * https://leetcode.com/problems/kth-missing-positive-number/description/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=EASY
 *
 * Data Structure - NA
 * Algorithm - Linear Search
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 167 ms, faster than 70.59%
 * Memory Usage: 36.5 MB, less than 86.27%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun findKthPositiveUsingLinearSearch(arr: IntArray, k: Int): Int {
    var result = k
    arr.forEach {
        if (it <= result) {
            result++
        } else {
            return result
        }
    }
    return result
}

private fun main() {

}
