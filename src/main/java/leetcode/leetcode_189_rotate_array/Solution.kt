package leetcode.leetcode_189_rotate_array

/**
 * leetcode - https://leetcode.com/problems/rotate-array/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [IntArray]
 * Algorithm - Using In-Place reversal
 *
 * Source - https://youtu.be/BHr381Guz3Y
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun rotate(nums: IntArray, k: Int): Unit {
    fun reverse(start: Int, end: Int) {
        var left = start
        var right = end
        while (left < right) {
            nums[left] = nums[right].also {
                nums[right] = nums[left]
            }
            left++
            right--
        }
    }
    val modK = k % nums.size
    if (modK == 0) {
        return
    }
    reverse(0, nums.lastIndex)
    reverse(0, modK - 1)
    reverse(modK, nums.lastIndex)
}

private fun main() {

}
