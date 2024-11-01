package leetcode.leetcode_55_jump_game

/**
 * leetcode - https://leetcode.com/problems/jump-game-ii/
 *
 * Using solution of leetcode 45 (https://leetcode.com/problems/jump-game-ii/)
 *
 * Stats
 * Runtime: 346 ms, faster than 92.73%
 * Memory Usage: 40.3 MB, less than 87.61%
 */
private fun canJump(nums: IntArray): Boolean {
    var i = 0
    var j: Int
    var max: Int
    var maxPos: Int
    while (i < nums.lastIndex) {
        if (nums[i] == 0) {
            return false
        }
        maxPos = i + nums[i]
        if (maxPos >= nums.lastIndex) {
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
    }
    return true
}

private fun main() {

}
