package leetcode.leetcode_2367_number_of_arithmetic_triplets

/**
 * leetcode - https://leetcode.com/problems/number-of-arithmetic-triplets/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 20 ms, faster than 54.55%
 * Memory Usage: 37.2 MB, less than 43.48%
 *
 * Time -
 * Space -
 */
private fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
    var result = 0
    var current: Int
    for (i in 0..(nums.lastIndex - 2)) {
        current = 0
        for (j in (i + 1)..nums.lastIndex) {
            if (nums[j] == nums[i] + diff * (current + 1)) {
                current++
                if (current == 2) {
                    result++
                    break
                }
            }
        }
    }
    return result
}

private fun main() {

}
