package leetcode.leetcode_349_intersection_of_two_arrays

/**
 * leetcode - https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Data Structure - [Set]
 * Algorithm - Set operations
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 207 ms, faster than 53.36%
 * Memory Usage: 38.6 MB, less than 37.22%
 *
 * m: nums1.size
 * n: nums2.size
 * Time - O(m + n)
 * Space - O(m)
 *
 * Companies - Google
 */
private fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val result = mutableListOf<Int>()
    val toAdd = mutableMapOf<Int, Boolean>()
    for (num in nums1) {
        toAdd[num] = true
    }
    for (num in nums2) {
        if (toAdd.getOrDefault(num, false)) {
            result.add(num)
            toAdd[num] = false
        }
    }
    return result.toIntArray()
}

/**
 * leetcode - https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Data Structure - [Set]
 * Algorithm - Set operations
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 207 ms, faster than 53.36%
 * Memory Usage: 38.6 MB, less than 37.22%
 *
 * m: nums1.size
 * n: nums2.size
 * Time - O(m + n)
 * Space - O(m + n)
 *
 * Companies - Google
 */
private fun intersectionUsingSet(nums1: IntArray, nums2: IntArray): IntArray {
    return (nums1.toSet() intersect nums2.toSet()).toIntArray()
}
