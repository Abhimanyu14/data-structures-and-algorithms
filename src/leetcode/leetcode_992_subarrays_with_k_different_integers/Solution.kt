package leetcode.leetcode_992_subarrays_with_k_different_integers

/**
 * leetcode - https://leetcode.com/problems/subarrays-with-k-different-integers/
 *
 * TODO(Abhi) - To revisit
 *
 * Using Sliding Window
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 255 ms, faster than 100.00%
 * Memory Usage: 41 MB, less than 100.00%
 *
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
    // Array to store the count of distinct values encountered
    var tempK = k
    val distinctCount = IntArray(nums.size + 1)

    var totalCount = 0
    var left = 0
    var right = 0
    var currCount = 0

    while (right < nums.size) {
        // Increment the count of the current element in the window
        if (distinctCount[nums[right++]]++ == 0) {
            // If encountering a new distinct element, decrement K
            tempK--
        }

        // If K becomes negative, adjust the window from the left
        if (tempK < 0) {
            // Move the left pointer until the count of distinct elements becomes valid again
            --distinctCount[nums[left++]]
            tempK++
            currCount = 0
        }

        // If K becomes zero, calculate subarrays
        if (tempK == 0) {
            // While the count of left remains greater than 1, keep shrinking the window from the left
            while (distinctCount[nums[left]] > 1) {
                --distinctCount[nums[left++]]
                currCount++
            }
            // Add the count of subarrays with K distinct elements to the total count
            totalCount += (currCount + 1)
        }
    }
    return totalCount
}


/**
 * leetcode - https://leetcode.com/problems/subarrays-with-k-different-integers/
 *
 * Using brute force
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N^3)
 * Space - O(N)
 */
private fun subarraysWithKDistinctUsingBruteForce(nums: IntArray, k: Int): Int {
    if (nums.size < k) {
        return 0
    }
    var result = 0
    val set = mutableSetOf<Int>()
    for (window in k..nums.size) {
        for (i in 0..(nums.lastIndex - window + 1)) {
            set.clear()
            for (j in i..<i + window) {
                set.add(nums[j])
            }
            if (set.size == k) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}
