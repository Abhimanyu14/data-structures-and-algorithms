package leetcode.leet_2200_to_2299.leet_2215_find_the_difference_of_two_arrays

/**
 * Stats
 * Runtime: 422 ms, faster than 100.00%
 * Memory Usage: 40.9 MB, less than 100.00%
 */
fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    return listOf(nums1.distinct() - nums2.distinct().toSet(), nums2.distinct() - nums1.distinct().toSet())
}

fun main() {
    println(findDifference(intArrayOf(1, 2, 3), intArrayOf(2, 4, 6)))
    println(findDifference(intArrayOf(1, 2, 3, 3), intArrayOf(1, 1, 2, 2)))
}
