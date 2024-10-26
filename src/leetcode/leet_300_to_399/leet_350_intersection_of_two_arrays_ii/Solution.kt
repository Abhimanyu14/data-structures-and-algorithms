package leetcode.leet_300_to_399.leet_350_intersection_of_two_arrays_ii

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/intersection-of-two-arrays-ii/?envType=daily-question&envId=2024-07-02
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 196 ms, faster than 60.32%
 * Memory Usage: 37.3 MB, less than 82.01%
 *
 * Time -
 * Space -
 */
private fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val result = mutableListOf<Int>()
    val counter1 = mutableMapOf<Int, Int>()
    val counter2 = mutableMapOf<Int, Int>()
    nums1.forEach {
        counter1[it] = counter1.getOrDefault(it, 0) + 1
    }
    nums2.forEach {
        counter2[it] = counter2.getOrDefault(it, 0) + 1
    }
    counter1.forEach { (key, value) ->
        if (counter2.contains(key)) {
            repeat(min(value, counter2.getOrDefault(key, 0))) {
                result.add(key)
            }
        }
    }
    return result.toIntArray()
}

private fun main() {

}
