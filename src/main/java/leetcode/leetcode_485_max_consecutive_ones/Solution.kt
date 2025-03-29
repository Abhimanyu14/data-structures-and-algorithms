package leetcode.leetcode_485_max_consecutive_ones

/**
 * leetcode - https://leetcode.com/problems/max-consecutive-ones/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 254 ms, faster than 98.77%
 * Memory Usage: 37.6 MB, less than 98.77%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var result = 0
    var counter = 0
    nums.forEach {
        if (it == 1) {
            counter++
            if (counter > result) {
                result = counter
            }
        } else {
            counter = 0
        }
    }
    return result
}

private fun main() {

}
