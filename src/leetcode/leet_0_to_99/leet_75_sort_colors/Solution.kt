package leetcode.leet_0_to_99.leet_75_sort_colors

/**
 * leetcode - https://leetcode.com/problems/sort-colors/
 *
 * Using two pointer
 *
 * Stats
 * Runtime: 208 ms, faster than 75.62%
 * Memory Usage: 36.6 MB, less than 13.93%
 */
private fun sortColors(nums: IntArray) {
    var left = -1
    var right = nums.size
    var temp: Int
    while (left < nums.lastIndex && nums[left + 1] == 0) {
        left++
    }
    while (right > 0 && nums[right - 1] == 2) {
        right--
    }
    var pointer = left + 1
    while (pointer < nums.size && pointer < right) {
        if (nums[pointer] == 0) {
            left++
            temp = nums[left]
            nums[left] = nums[pointer]
            nums[pointer] = temp
            pointer++
        } else if (nums[pointer] == 2) {
            right--
            temp = nums[right]
            nums[right] = nums[pointer]
            nums[pointer] = temp
        } else {
            pointer++
        }
    }
}

private fun main() {
    val input1 = intArrayOf(1, 2, 0)
    sortColors(input1)
    println(input1.joinToString(", "))
}
