package leetcode.leetcode_2448_minimum_cost_to_make_array_equal

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-cost-to-make-array-equal/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */


/**
 * leetcode - https://leetcode.com/problems/minimum-cost-to-make-array-equal/
 *
 * Using brute force
 *
 * Stats
 * Time Limit Exceeded
 */
fun minCostBruteForce(nums: IntArray, cost: IntArray): Long {
    var result = Long.MAX_VALUE
    var minValue = Int.MAX_VALUE
    var maxValue = 0
    var temp: Long
    nums.forEach {
        minValue = min(minValue, it)
        maxValue = max(maxValue, it)
    }
    for (i in minValue..maxValue) {
        temp = 0L
        cost.forEachIndexed { index, costValue ->
            temp += abs(nums[index] - i).toLong() * costValue
        }
        result = min(result, temp)
    }
    return result
}

private fun main() {

}
