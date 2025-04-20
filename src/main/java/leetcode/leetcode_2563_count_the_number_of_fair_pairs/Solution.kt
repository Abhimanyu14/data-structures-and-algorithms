package leetcode.leetcode_2563_count_the_number_of_fair_pairs

/**
 * leetcode - https://leetcode.com/problems/count-the-number-of-fair-pairs/?envType=daily-question&envId=2024-11-13
 *
 * Data Structure - [Array]
 * Algorithm - Sorting and Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 70 ms, faster than 100.00%
 * Memory Usage: 67.5 MB, less than 100.00%
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Amazon, Google
 */
private fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
    var result = 0L
    val sorted = nums.sorted()
    fun findFirstIndex(x: Int, start: Int): Int {
        var left = start
        var right = sorted.size
        var mid: Int
        while (left < right) {
            mid = left + (right - left) / 2
            if (sorted[mid] >= x) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }
    for (i in sorted.indices) {
        // (firstIndexOf(upper + 1 - num) - 1) - firstIndexOf(lower - num) + 1
        result += findFirstIndex(upper - sorted[i] + 1, i + 1) - findFirstIndex(lower - sorted[i], i + 1)
    }
    return result
}

private fun countFairPairsUsingSortingInput(nums: IntArray, lower: Int, upper: Int): Long {
    var result = 0L
    nums.sort()
    for (i in 0..<nums.lastIndex) {
        var left = i + 1
        var right = nums.size
        // Index of number where - nums[i] + nums[left] > upper
        while (left < right) {
            val mid = left + ((right - left) / 2)
            if (nums[i] + nums[mid] > upper) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        val rightEnd = left - 1
        left = i + 1
        right = rightEnd + 1
        // Index of number where - nums[i] + nums[left] >= lower
        while (left < right) {
            val mid = left + ((right - left) / 2)
            if (nums[i] + nums[mid] >= lower) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        val leftEnd = left
        if (rightEnd >= leftEnd) {
            result += (rightEnd - leftEnd + 1)
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/count-the-number-of-fair-pairs/?envType=daily-question&envId=2024-11-13
 *
 * Using brute force
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun countFairPairsUsingBruteForce(nums: IntArray, lower: Int, upper: Int): Long {
    var result = 0L
    for (i in 0..<nums.lastIndex) {
        for (j in (i + 1)..nums.lastIndex) {
            if ((nums[i] + nums[j]) in lower..upper) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}
