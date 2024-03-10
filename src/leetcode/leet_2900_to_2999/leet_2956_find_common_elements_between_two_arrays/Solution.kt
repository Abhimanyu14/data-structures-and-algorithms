package leetcode.leet_2900_to_2999.leet_2956_find_common_elements_between_two_arrays

/**
 * leetcode - https://leetcode.com/problems/find-common-elements-between-two-arrays/
 *
 * Using two sets and count
 *
 * Stats
 * Runtime: 304 ms, faster than 63.08%
 * Memory Usage: 42.2 MB, less than 60.00%
 */
private fun findIntersectionValues(nums1: IntArray, nums2: IntArray): IntArray {
    val set1 = nums1.toSet()
    val set2 = nums2.toSet()
    return intArrayOf(
        nums1.count { it in set2 },
        nums2.count { it in set1 },
    )
}

/**
 * leetcode - https://leetcode.com/problems/find-common-elements-between-two-arrays/
 *
 * Using two sets
 *
 * Stats
 * Runtime: 309 ms, faster than 46.15%
 * Memory Usage: 42 MB, less than 66.15%
 */
private fun findIntersectionValuesUsingTwoSets(nums1: IntArray, nums2: IntArray): IntArray {
    val set1 = nums1.toSet()
    val set2 = nums2.toSet()
    val result = IntArray(2)
    var counter = 0
    nums1.forEach {
        if (set2.contains(it)) {
            counter++
        }
    }
    result[0] = counter
    counter = 0
    nums2.forEach {
        if (set1.contains(it)) {
            counter++
        }
    }
    result[1] = counter
    return result
}

private fun main() {

}
