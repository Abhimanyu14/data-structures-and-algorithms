package leetcode.leetcode_480_sliding_window_median

/**
 * leetcode - https://leetcode.com/problems/sliding-window-median/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [DoubleArray], [List]
 * Algorithm - Sorting
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N * k * log(k))
 * Space - O(N * k)
 *
 * Companies - Amazon, Apple, Google, Meta
 */
private fun medianSlidingWindowUsingBruteForce(nums: IntArray, k: Int): DoubleArray {
    val result = DoubleArray(nums.lastIndex - k + 1 + 1)
    for (i in 0..(nums.lastIndex - k + 1)) {
        val current = IntArray(k)
        for (j in i..<i + k) {
            current[j - i] = nums[j]
        }
        current.sort()
        if (k % 2 == 1) {
            result[i] = current[k / 2].toDouble()
        } else {
            result[i] = (current[(k / 2) - 1].toDouble() + current[(k / 2)]) / 2
        }
    }
    return result
}

private fun main() {

}
