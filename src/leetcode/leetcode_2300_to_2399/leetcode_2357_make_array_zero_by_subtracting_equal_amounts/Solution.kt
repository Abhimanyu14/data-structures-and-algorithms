package leetcode.leetcode_2300_to_2399.leetcode_2357_make_array_zero_by_subtracting_equal_amounts

/**
 * Using distinct and count
 *
 * leetcode - https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
 *
 * Stats
 * Runtime: 179 ms, faster than 81.48%
 * Memory Usage: 36.1 MB, less than 44.44%
 */
private fun minimumOperations(nums: IntArray): Int {
    return nums.distinct().count { it != 0 }
}

/**
 * Using Set
 *
 * leetcode - https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
 *
 * Stats
 * Runtime: 157 ms, faster than 88.89%
 * Memory Usage: 33.7 MB, less than 100.00%
 */
private fun minimumOperationsUsingSet(nums: IntArray): Int {
    val set = mutableSetOf<Int>()
    nums.forEach {
        if (it != 0) {
            set.add(it)
        }
    }
    return set.size
}

/**
 * Using Set, toMutableSet()
 *
 * leetcode - https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
 *
 * Stats
 * Runtime: 195 ms, faster than 81.82%
 * Memory Usage: 36.2 MB, less than 42.42%
 */
private fun minimumOperationsUsingToMutableSet(nums: IntArray): Int {
    val set = nums.toMutableSet()
    set.remove(0)
    return set.size
}

private fun main() {
    println(minimumOperations(intArrayOf(1, 5, 0, 3, 5)) == 3)
    println(minimumOperations(intArrayOf(0)) == 0)
}
