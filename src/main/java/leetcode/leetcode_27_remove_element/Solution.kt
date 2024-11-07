package leetcode.leetcode_27_remove_element

/**
 * leetcode - https://leetcode.com/problems/remove-element/
 * 
 * Maintains order
 *
 * Stats
 * Runtime: 338 ms, faster than 9.70%
 * Memory Usage: 37 MB, less than 8.77%
 */
fun removeElement(nums: IntArray, `val`: Int): Int {
    var result = 0
    for (i in 0..nums.lastIndex) {
        if (nums[i] != `val`) {
            nums[result] = nums[i]
            result++
        }
    }
    return result
}

/**
 * Does not maintain order
 *
 * Stats
 * Runtime: 194 ms, faster than 85.82%
 * Memory Usage: 37.2 MB, less than 7.28%
 */
fun removeElementWithoutOrder(nums: IntArray, `val`: Int): Int {
    var start = 0
    var end = nums.lastIndex
    while (start <= end) {
        if (nums[start] == `val`) {
            nums[start] = nums[end]
            end--
        } else {
            start++
        }
    }
    return start
}

private fun main() {
    println(removeElementWithoutOrder(intArrayOf(3, 2, 2, 3), 3))
}
