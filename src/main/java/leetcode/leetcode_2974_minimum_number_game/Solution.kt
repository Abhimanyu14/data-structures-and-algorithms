package leetcode.leetcode_2974_minimum_number_game

/**
 * leetcode - https://leetcode.com/problems/minimum-number-game/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 19 ms, faster than 27.27%
 * Memory Usage: 39 MB, less than 86.21%
 *
 * Time -
 * Space -
 */
private fun numberGame(nums: IntArray): IntArray {
    nums.sort()
    for (i in 0..(nums.lastIndex / 2)) {
        nums[2 * i] = nums[2 * i + 1].also {
            nums[2 * i + 1] = nums[2 * i]
        }
    }
    return nums
}

private fun main() {

}
