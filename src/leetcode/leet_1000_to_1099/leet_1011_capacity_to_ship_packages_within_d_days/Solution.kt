package leetcode.leet_1000_to_1099.leet_1011_capacity_to_ship_packages_within_d_days

import kotlin.math.ceil
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 *
 * Using binary search
 *
 * Stats
 * Runtime: 285 ms, faster than 43.24%
 * Memory Usage: 43.3 MB, less than 94.59%
 */
private fun shipWithinDays(weights: IntArray, days: Int): Int {
    fun isPossible(weightCapacity: Int): Boolean {
        var daysRequired = 1
        var currentWeight = 0
        weights.forEach {
            currentWeight += it
            if (currentWeight > weightCapacity) {
                daysRequired++
                currentWeight = it
            }
        }
        return daysRequired <= days
    }

    val totalWeight = weights.sum()
    var low = max(weights.max(), ceil(totalWeight.toFloat() / days).toInt())
    var high = totalWeight
    while (low < high) {
        val mid = low + ((high - low) / 2)
        if (isPossible(mid)) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return low
}

/**
 * leetcode - https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 *
 * Using linear search
 *
 * Stats
 * Runtime: 351 ms, faster than 5.41%
 * Memory Usage: 44.4 MB, less than 24.32%
 */
private fun shipWithinDaysLinear(weights: IntArray, days: Int): Int {
    fun isPossible(n: Int): Boolean {
        var result = 0
        var currentWeight = 0
        weights.forEach {
            currentWeight += it
            if (currentWeight > n) {
                result++
                currentWeight = it
            }
        }
        if (currentWeight > 0) {
            result++
        }
        return result <= days
    }

    var maxWeight = 0
    var sum = 0
    weights.forEach {
        maxWeight = max(maxWeight, it)
        sum += it
    }
    var current = max(maxWeight, ceil(sum.toFloat() / days).toInt())
    while (!isPossible(current)) {
        current++
    }
    return current
}

private fun main() {

}
