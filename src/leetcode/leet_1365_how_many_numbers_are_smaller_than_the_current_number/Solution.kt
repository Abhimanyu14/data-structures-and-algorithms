package leetcode.leet_1365_how_many_numbers_are_smaller_than_the_current_number

import common.sorting.quicksortDriver

fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    val newArray = IntArray(nums.size) { nums[it] }
    quicksortDriver(newArray)
    nums.forEachIndexed { i, ele ->
        newArray.find { it == ele }?.let {
            result[i] = i
        }
    }
    return result
}

fun main() {
    val input = intArrayOf(8, 1, 2, 2, 3)
    println(smallerNumbersThanCurrent(input).joinToString(" "))
}
