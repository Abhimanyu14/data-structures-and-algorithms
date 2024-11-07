package leetcode.leetcode_75_sort_colors

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

/**
 * leetcode - https://leetcode.com/problems/relative-sort-array/?envType=daily-question&envId=2024-06-11
 *
 * Using three pointers
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 177 ms, faster than 20.10%
 * Memory Usage: 34.7 MB, less than 61.32%
 *
 * Time -
 * Space -
 */
private fun sortColorsUsingThreePointers(nums: IntArray): Unit {
    var zeroCount = 0
    var oneCount = 0
    var twoCount = 0
    nums.forEach {
        when (it) {
            0 -> {
                zeroCount++
            }
            1 -> {
                oneCount++
            }
            else -> {
                twoCount++
            }
        }
    }

    var index = 0
    while (zeroCount > 0) {
        nums[index] = 0
        index++
        zeroCount--
    }
    while (oneCount > 0) {
        nums[index] = 1
        index++
        oneCount--
    }
    while (twoCount > 0) {
        nums[index] = 2
        index++
        twoCount--
    }
}

private fun main() {
    val input1 = intArrayOf(1, 2, 0)
    sortColors(input1)
    println(input1.joinToString(", "))
}
