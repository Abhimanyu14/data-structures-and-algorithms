package leetcode.leet_300_to_399.leet_349_intersection_of_two_arrays

/**
 * Stats
 * Runtime: 301 ms, faster than 76.23%
 * Memory Usage: 40.9 MB, less than 31.97%
 */
fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    return (nums1.toSet() intersect nums2.toSet()).toIntArray()
}

private fun main() {
    println(intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).joinToString())
    println(
        intersection(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).joinToString()
    )
}
