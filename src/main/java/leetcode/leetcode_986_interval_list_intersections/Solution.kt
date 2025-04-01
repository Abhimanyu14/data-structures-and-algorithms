package leetcode.leetcode_986_interval_list_intersections

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/interval-list-intersections/description/
 *
 * Data Structure - [List], [IntArray]
 * Algorithm - Intervals, Iteration
 *
 * Math methods - [min], [max]
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(M + N)
 * Space - O(M + N)
 *
 * Companies - Meta
 */
private fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    var index1 = 0
    var index2 = 0
    while (index1 <= firstList.lastIndex && index2 <= secondList.lastIndex) {
        val maxStarting = max(firstList[index1][0], secondList[index2][0])
        val minEnding = min(firstList[index1][1], secondList[index2][1])
        if (maxStarting <= minEnding) {
            result.add(intArrayOf(maxStarting, minEnding))
        }
        if (firstList[index1][1] == minEnding) {
            index1++
        } else {
            index2++
        }
    }
    return result.toTypedArray()
}

/**
 * leetcode - https://leetcode.com/problems/interval-list-intersections/description/
 *
 * Data Structure - [List], [IntArray]
 * Algorithm - Intervals, Iteration
 *
 * List methods - [isEmpty], [toTypedArray]
 * Array methods - [emptyArray]
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(M + N)
 * Space - O(M + N)
 *
 * Companies - Meta
 */
private fun intervalIntersectionNaive(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
    if (firstList.isEmpty() || secondList.isEmpty()) {
        return emptyArray()
    }
    val result = mutableListOf<IntArray>()
    var index1 = 0
    var index2 = 0
    while (index1 <= firstList.lastIndex && index2 <= secondList.lastIndex) {
        if (firstList[index1][0] < secondList[index2][0]) { // first list starts before second list starts
            if (firstList[index1][1] < secondList[index2][0]) { // first list ends before second list starts
                index1++
            } else {
                if (firstList[index1][1] < secondList[index2][1]) { // first list ends before second list ends
                    result.add(intArrayOf(secondList[index2][0], firstList[index1][1]))
                    index1++
                } else if (firstList[index1][1] == secondList[index2][1]) { // first list ends when second list ends
                    result.add(intArrayOf(secondList[index2][0], firstList[index1][1]))
                    index1++
                    index2++
                } else { // first list ends after second list ends
                    result.add(intArrayOf(secondList[index2][0], secondList[index2][1]))
                    index2++
                }
            }
        } else if (firstList[index1][0] == secondList[index2][0]) { // first list starts when second list starts
            if (firstList[index1][1] < secondList[index2][1]) { // first list ends before second list ends
                result.add(intArrayOf(firstList[index1][0], firstList[index1][1]))
                index1++
            } else if (firstList[index1][1] == secondList[index2][1]) { // first list ends when second list ends
                result.add(intArrayOf(firstList[index1][0], firstList[index1][1]))
                index1++
                index2++
            } else { // first list ends after second list ends
                result.add(intArrayOf(firstList[index1][0], secondList[index2][1]))
                index2++
            }
        } else { // first list starts after second list starts
            if (secondList[index2][1] < firstList[index1][0]) { //
                index2++
            } else {
                if (secondList[index2][1] < firstList[index1][1]) {
                    result.add(intArrayOf(firstList[index1][0], secondList[index2][1]))
                    index2++
                } else if (secondList[index2][1] == firstList[index1][1]) {
                    result.add(intArrayOf(firstList[index1][0], secondList[index2][1]))
                    index1++
                    index2++
                } else {
                    result.add(intArrayOf(firstList[index1][0], firstList[index1][1]))
                    index1++
                }
            }
        }
    }
    return result.toTypedArray()
}

private fun main() {

}
