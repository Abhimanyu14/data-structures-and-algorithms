package leetcode.leet_2357_make_array_zero_by_subtracting_equal_amounts

/**
 * Using Hashset
 *
 * Stats
 * Runtime: 195 ms, faster than 81.82%
 * Memory Usage: 36.2 MB, less than 42.42%
 */
private fun minimumOperations(nums: IntArray): Int {
    val set = nums.toHashSet()
    set.remove(0)
    return set.size
}

fun main() {
    println(minimumOperations(intArrayOf(1, 5, 0, 3, 5)) == 3)
    println(minimumOperations(intArrayOf(0)) == 0)
}
