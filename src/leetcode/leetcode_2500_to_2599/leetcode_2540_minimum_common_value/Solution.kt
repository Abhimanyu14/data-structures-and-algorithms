package leetcode.leetcode_2500_to_2599.leetcode_2540_minimum_common_value

/**
 * leetcode - https://leetcode.com/problems/minimum-common-value/?envType=daily-question&envId=2024-03-09
 *
 * Using two pointers
 *
 * Stats
 * Runtime: 396 ms, faster than 76.32%
 * Memory Usage: 60.1 MB, less than 50.00%
 */
private fun getCommon(nums1: IntArray, nums2: IntArray): Int {
    var p1 = 0
    var p2 = 0
    while (p1 < nums1.size && p2 < nums2.size) {
        if (nums1[p1] == nums2[p2]) {
            return nums1[p1]
        } else if (nums1[p1] > nums2[p2]) {
            p2++
        } else {
            p1++
        }
    }
    return -1
}

private fun main() {

}
