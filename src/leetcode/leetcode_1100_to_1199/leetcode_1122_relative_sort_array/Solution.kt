package leetcode.leetcode_1100_to_1199.leetcode_1122_relative_sort_array

import java.util.Arrays


/**
 * leetcode - https://leetcode.com/problems/relative-sort-array/?envType=daily-question&envId=2024-06-11
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray? {
    val maxElement = Arrays.stream(arr1).max().orElse(0)
    val count = IntArray(maxElement + 1)

    // Count occurrences of each element
    for (element in arr1) {
        count[element]++
    }

    val result: MutableList<Int> = ArrayList()
    // Add elements as per relative order
    for (value in arr2) {
        while (count[value] > 0) {
            result.add(value)
            count[value]--
        }
    }

    // Add remaining elements in ascending order
    for (num in 0..maxElement) {
        while (count[num] > 0) {
            result.add(num)
            count[num]--
        }
    }

    // Convert ArrayList to array
    return result.stream().mapToInt { obj: Int -> obj }.toArray()
}

private fun main() {

}
