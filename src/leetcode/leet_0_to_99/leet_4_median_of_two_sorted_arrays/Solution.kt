package leetcode.leet_0_to_99.leet_4_median_of_two_sorted_arrays

/**
 * Using pointers and loops
 *
 * Stats
 * Runtime: 489 ms, faster than 70.93%
 * Memory Usage: 55.4 MB, less than 67.78%
 */
private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var p1 = -1
    var p2 = -1
    var index = -1
    var result = 0.0
    val isEven = (nums1.size + nums2.size) % 2 == 0
    val medianIndex = (nums1.size + nums2.size) / 2
    while (index < medianIndex) {
        index++
        if ((p1 == nums1.lastIndex) || ((p2 != nums2.lastIndex) && (nums1[p1 + 1] > nums2[p2 + 1]))) {
            p2++
            if (isEven) {
                if (index >= medianIndex - 1) {
                    result += nums2[p2].toDouble()
                    if (index == medianIndex) {
                        return result / 2
                    }
                }
            } else {
                if (index == medianIndex) {
                    return nums2[p2].toDouble()
                }
            }
        } else {
            p1++
            if (isEven) {
                if (index >= medianIndex - 1) {
                    result += nums1[p1].toDouble()
                    if (index == medianIndex) {
                        return result / 2
                    }
                }
            } else {
                if (index == medianIndex) {
                    return nums1[p1].toDouble()
                }
            }
        }
    }
    return 0.0
}

private fun main() {
    println(findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
    println(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
    println(findMedianSortedArrays(intArrayOf(2, 2, 4, 4), intArrayOf(2, 2, 4, 4)))
}
