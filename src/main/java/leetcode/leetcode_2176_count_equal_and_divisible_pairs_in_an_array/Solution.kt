package leetcode.leetcode_2176_count_equal_and_divisible_pairs_in_an_array

/**
 * leetcode - https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/
 *
 * Data Structure - Map and List
 * Algorithm - Hashing, Counting and Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N ^ 2)
 * Space - O(N)
 */
private fun countPairs(nums: IntArray, k: Int): Int {
    var result = 0
    val counter = mutableMapOf<Int, MutableList<Int>>()
    for (i in nums.indices) {
        counter.computeIfAbsent(nums[i]) { mutableListOf() }.add(i)
    }
    for ((_, value) in counter) {
        for (i in 0..<value.lastIndex) {
            for (j in (i + 1)..value.lastIndex) {
                if (value[i] * value[j] % k == 0) {
                    result++
                }
            }
        }
    }
    return result
}

private fun main() {

}
