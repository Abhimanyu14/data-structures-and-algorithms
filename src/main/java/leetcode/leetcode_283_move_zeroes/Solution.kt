package leetcode.leetcode_283_move_zeroes

/**
 * leetcode - https://leetcode.com/problems/move-zeroes/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Stats
 * Runtime: 564 ms, faster than 58.23%
 * Memory Usage: 65.2 MB, less than 17.84%
 */
fun moveZeroes(nums: IntArray): Unit {
    var result = 0
    for (i in 0..nums.lastIndex) {
        if (nums[i] != 0) {
            nums[result++] = nums[i]
        }
    }
    while (result <= nums.lastIndex) {
        nums[result++] = 0
    }
}

private fun main() {
    val input = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(input)
    println(input.joinToString())
}
