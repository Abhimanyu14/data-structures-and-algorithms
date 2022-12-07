package leetcode.leet_2300_to_2399.leet_2357_make_array_zero_by_subtracting_equal_amounts

/**
 * leetcode - https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
 *
 * Using Set
 *
 * Stats
 * Runtime: 195 ms, faster than 81.82%
 * Memory Usage: 36.2 MB, less than 42.42%
 */
private fun minimumOperations(nums: IntArray): Int {
    val set = nums.toMutableSet()
    set.remove(0)
    return set.size
}

fun main() {
    println(minimumOperations(intArrayOf(1, 5, 0, 3, 5)) == 3)
    println(minimumOperations(intArrayOf(0)) == 0)
}
