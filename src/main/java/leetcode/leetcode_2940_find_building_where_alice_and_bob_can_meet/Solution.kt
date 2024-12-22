package leetcode.leetcode_2940_find_building_where_alice_and_bob_can_meet

import java.util.Stack
import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/?envType=daily-question&envId=2024-12-22
 *
 * Data Structure - Monotonic Stack
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 1854 ms, faster than 100.00%
 * Memory Usage: 81.1 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun leftmostBuildingQueriesUsingMonotonicStack(heights: IntArray, queries: Array<IntArray>): IntArray {
    fun getNextGreaterElementIndices(): IntArray {
        val nextGreaterElementIndicesArray = IntArray(heights.size) { -1 }
        nextGreaterElementIndicesArray[nextGreaterElementIndicesArray.lastIndex] = -1
        val monotonicStack = Stack<IntArray>()
        monotonicStack.push(intArrayOf(heights[heights.lastIndex], heights.lastIndex))
        for (i in (heights.lastIndex - 1) downTo 0) {
            while (monotonicStack.isNotEmpty() && monotonicStack.peek()[0] <= heights[i]) {
                monotonicStack.pop()
            }
            nextGreaterElementIndicesArray[i] = if (monotonicStack.isEmpty()) {
                -1
            } else {
                monotonicStack.peek()[1]
            }
            monotonicStack.push(intArrayOf(heights[i], i))
        }
        return nextGreaterElementIndicesArray
    }

    val result = IntArray(queries.size) { -1 }
    val nextGreaterElementIndices = getNextGreaterElementIndices()
    for (i in queries.indices) {
        val minIndex = min(queries[i][0], queries[i][1])
        val maxIndex = max(queries[i][0], queries[i][1])
        if (queries[i][0] == queries[i][1]) {
            result[i] = queries[i][0]
        } else if (heights[minIndex] < heights[maxIndex]) {
            result[i] = maxIndex
        } else {
            val maxValue = max(heights[queries[i][0]], heights[queries[i][1]])
            if (nextGreaterElementIndices[minIndex] == -1 || nextGreaterElementIndices[maxIndex] == -1) {
                result[i] = -1
                continue
            }
            var candidateIndex = max(nextGreaterElementIndices[maxIndex], nextGreaterElementIndices[minIndex])
            while (candidateIndex != -1 && heights[candidateIndex] <= maxValue) {
                candidateIndex = nextGreaterElementIndices[candidateIndex]
            }
            result[i] = candidateIndex
        }
    }
    return result
}

private fun main() {

}
