package leetcode.leet_0_to_99.leet_26_remove_duplicates_from_sorted_array

/**
 * Stats
 * Runtime: 440 ms, faster than 53.51%
 * Memory Usage: 47 MB, less than 33.05%
 */
fun removeDuplicates(nums: IntArray): Int {
    var result = 1
    for (i in 1..nums.lastIndex) {
        if (nums[result - 1] != nums[i]) {
            nums[result] = nums[i]
            result++
        }
    }
    return result
}

fun main() {
    println(removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
}
