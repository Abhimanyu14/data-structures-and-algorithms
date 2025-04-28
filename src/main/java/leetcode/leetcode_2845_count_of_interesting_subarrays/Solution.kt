package leetcode.leetcode_2845_count_of_interesting_subarrays


/**
 * leetcode - https://leetcode.com/problems/count-of-interesting-subarrays/description/?envType=daily-question&envId=2025-04-25
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N ^ 2)
 * Space - O(1)
 *
 * Companies - Google
 */
private fun countInterestingSubarrays(nums: List<Int>, modulo: Int, k: Int): Long {
    var result: Long = 0
    val counter = mutableMapOf<Int, Int>()
    var prefix = 0
    counter[0] = 1
    for (num in nums) {
        if (num % modulo == k) {
            prefix++
        }
        result += counter.getOrDefault((prefix - k + modulo) % modulo, 0).toLong()
        counter[prefix % modulo] = counter.getOrDefault(prefix % modulo, 0) + 1
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/count-of-interesting-subarrays/description/?envType=daily-question&envId=2025-04-25
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N ^ 2)
 * Space - O(1)
 *
 * Companies - Google
 */
private fun countInterestingSubarraysUsingBruteForce(nums: List<Int>, modulo: Int, k: Int): Long {
    var result = 0L
    for (i in nums.indices) {
        var count = 0
        for (j in i..nums.lastIndex) {
            if (nums[j] % modulo == k) {
                count++
            }
            if (count % modulo == k) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}
