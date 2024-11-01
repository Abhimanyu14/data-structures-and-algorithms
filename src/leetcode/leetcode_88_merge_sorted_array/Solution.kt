package leetcode.leetcode_88_merge_sorted_array

/**
 * leetcode - https://leetcode.com/problems/merge-sorted-array/
 *
 * Using two pointer
 *
 * Stats
 * Runtime: 319 ms, faster than 36.53%
 * Memory Usage: 36.1 MB, less than 40.72%
 */
private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var insertPointer = m + n - 1
    var first = m - 1
    var last = n - 1
    while (insertPointer >= 0) {
        if (last > -1 && first > -1) {
            if (nums2[last] > nums1[first]) {
                nums1[insertPointer] = nums2[last]
                last--
            } else {
                nums1[insertPointer] = nums1[first]
                first--
            }
        } else if (first > -1) {
            nums1[insertPointer] = nums1[first]
            first--
        } else {
            nums1[insertPointer] = nums2[last]
            last--
        }
        insertPointer--
    }
}

private fun main() {

}
