package leetcode.leetcode_295_find_median_from_data_stream

/**
 * leetcode - https://leetcode.com/problems/find-median-from-data-stream/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [List]
 * Algorithm - BruteForce
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * - addNum - O(N)
 * - findMedian - O(1)
 *
 * Space - O(N)
 *
 * Companies - Google, Meta
 */
private class MedianFinder() {
    private var nums = mutableListOf<Int>()

    fun addNum(num: Int) {
        var index = 0
        while (index <= nums.lastIndex && nums[index] < num) {
            index++
        }
        nums.add(index, num)
    }

    fun findMedian(): Double {
        return if (nums.size % 2 == 0) {
            ((nums[nums.size / 2] / 2.0) + (nums[(nums.size / 2) - 1] / 2.0))
        } else {
            nums[nums.size / 2].toDouble()
        }
    }
}

private fun main() {

}
