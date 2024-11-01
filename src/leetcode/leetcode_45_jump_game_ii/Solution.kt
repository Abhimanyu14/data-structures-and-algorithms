package leetcode.leetcode_45_jump_game_ii

/**
 * leetcode - https://leetcode.com/problems/jump-game-ii/
 *
 * Using greedy
 *
 * Stats
 * Runtime: 242 ms, faster than 88.61%
 * Memory Usage: 38.6 MB, less than 81.65%
 */
private fun jump(nums: IntArray): Int {
    var result = 0
    var i = 0
    var j: Int
    var max: Int
    var maxPos: Int
    while (i < nums.lastIndex) {
        maxPos = i + nums[i]
        if (maxPos >= nums.lastIndex) {
            result++
            break
        }
        max = nums[maxPos]
        j = maxPos - 1
        while (j > i) {
            if (max < (nums[j] - (i + nums[i] - j))) {
                max = nums[j] - (i + nums[i] - j)
                maxPos = j
            }
            j--
        }
        i = maxPos
        result++
    }
    return result
}

private fun main() {
    println(jump(intArrayOf(2, 3, 1, 1, 4)))
    println(jump(intArrayOf(2, 3, 0, 1, 4)))
}
