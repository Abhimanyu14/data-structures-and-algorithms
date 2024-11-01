package leetcode.leetcode_3068_find_the_maximum_sum_of_node_values

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - leetcode_3068_find_the_maximum_sum_of_node_values
 *
 * Using Greedy (Finding local maxima and minima)
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 556 ms, faster than 40.00%
 * Memory Usage: 69.1 MB, less than 60.00%
 *
 * Time -
 * Space -
 */
private fun maximumValueSum(nums: IntArray, k: Int, edges: Array<IntArray>): Long {
    var sum: Long = 0
    var count = 0
    var positiveMinimum = (1 shl 30)
    var negativeMaximum = -1 * (1 shl 30)

    nums.forEach { nodeValue ->
        val operatedNodeValue = nodeValue xor k
        sum += nodeValue.toLong()
        val netChange = operatedNodeValue - nodeValue
        if (netChange > 0) {
            positiveMinimum = min(positiveMinimum.toDouble(), netChange.toDouble()).toInt()
            sum += netChange.toLong()
            count++
        } else {
            negativeMaximum = max(negativeMaximum.toDouble(), netChange.toDouble()).toInt()
        }
    }

    // If the number of positive netChange values is even, return the sum.
    if (count % 2 == 0) {
        return sum
    }

    // Otherwise return the maximum of both discussed cases.
    return max(sum - positiveMinimum, sum + negativeMaximum)
}

private fun main() {

}
