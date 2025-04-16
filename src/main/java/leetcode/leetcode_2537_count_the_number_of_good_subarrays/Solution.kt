package leetcode.leetcode_2537_count_the_number_of_good_subarrays

/**
 * leetcode - https://leetcode.com/problems/count-the-number-of-good-subarrays/description/?envType=daily-question&envId=2025-04-16
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Map]
 * Algorithm - Counting and Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N ^ 2)
 * Space - O(N)
 *
 * Companies - Amazon, Uber
 */
private fun countGoodUsingMinorEarlyLoopCompletion(nums: IntArray, k: Int): Long {
    var result = 0L
    for (i in 0..<nums.lastIndex) {
        val counter = mutableMapOf<Int, Int>()
        var currentPairsCount = 0
        counter[nums[i]] = 1
        for (j in (i + 1)..nums.lastIndex) {
            counter[nums[j]] = counter.getOrDefault(nums[j], 0) + 1
            currentPairsCount += counter.getOrDefault(nums[j], 0) - 1
            if (currentPairsCount >= k) {
                result += nums.lastIndex - j + 1
                break
            }
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/count-the-number-of-good-subarrays/description/?envType=daily-question&envId=2025-04-16
 *
 * Data Structure - [Map]
 * Algorithm - Counting and Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N ^ 2)
 * Space - O(N)
 *
 * Companies - Amazon, Uber
 */
private fun countGoodUsingBruteForce(nums: IntArray, k: Int): Long {
    var result = 0L
    for (i in 0..<nums.lastIndex) {
        val counter = mutableMapOf<Int, Int>()
        var currentPairsCount = 0
        counter[nums[i]] = 1
        for (j in (i + 1)..nums.lastIndex) {
            counter[nums[j]] = counter.getOrDefault(nums[j], 0) + 1
            currentPairsCount += counter.getOrDefault(nums[j], 0) - 1
            if (currentPairsCount >= k) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}
