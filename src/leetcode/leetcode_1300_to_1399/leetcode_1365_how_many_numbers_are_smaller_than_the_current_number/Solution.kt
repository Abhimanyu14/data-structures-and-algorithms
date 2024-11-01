package leetcode.leetcode_1300_to_1399.leetcode_1365_how_many_numbers_are_smaller_than_the_current_number

/**
 * leetcode - https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * Using brute force
 *
 * Stats
 * Runtime: 202 ms, faster than 98.31%
 * Memory Usage: 36.9 MB, less than 91.53%
 *
 * Time: O(N^2)
 * Space: O(N) - Only the answer, else O(1)
 */
private fun smallerNumbersThanCurrentBruteForce(nums: IntArray): IntArray {
    var count: Int
    val result = IntArray(nums.size)
    nums.forEachIndexed { i, pivot ->
        count = 0
        nums.forEachIndexed { j, num ->
            if (i != j && num < pivot) {
                count++
            }
        }
        result[i] = count
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * Using count array
 *
 * Stats
 * Runtime: 205 ms, faster than 98.31%
 * Memory Usage: 38.1 MB, less than 77.97%
 *
 * Time: O(N)
 * Space: O(N)
 */
private fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    val buckets = IntArray(102)
    nums.forEach {
        buckets[it]++
    }
    for (index in 1..buckets.lastIndex) {
        buckets[index] += buckets[index - 1]
    }
    val result = IntArray(nums.size)
    for (i in result.indices) {
        if (nums[i] == 0) {
            result[i] = 0
        } else {
            result[i] = buckets[nums[i] - 1]
        }
    }
    return result
}

private fun main() {
    val input = intArrayOf(8, 1, 2, 2, 3)
    println(smallerNumbersThanCurrent(input).joinToString(" "))
}
