package leetcode.leetcode_349_intersection_of_two_arrays

/**
 * leetcode - https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Using set operations
 *
 * Stats
 * Runtime: 207 ms, faster than 53.36%
 * Memory Usage: 38.6 MB, less than 37.22%
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
