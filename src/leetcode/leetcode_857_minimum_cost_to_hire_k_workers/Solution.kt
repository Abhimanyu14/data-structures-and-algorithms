package leetcode.leetcode_857_minimum_cost_to_hire_k_workers

import java.util.Collections
import java.util.PriorityQueue
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-cost-to-hire-k-workers/?envType=daily-question&envId=2024-05-11
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
    var totalCost = Double.MAX_VALUE
    var currentTotalQuality = 0.0
    val wageToQualityRatio: MutableList<Pair<Double, Int>> = ArrayList()

    // Calculate wage-to-quality ratio for each worker
    for (i in quality.indices) {
        wageToQualityRatio.add(Pair(wage[i].toDouble() / quality[i], quality[i]))
    }

    // Sort workers based on their wage-to-quality ratio
    Collections.sort(wageToQualityRatio, compareBy { it.first })

    // Use a priority queue to keep track of the highest quality workers
    val highestQualityWorkers = PriorityQueue(Collections.reverseOrder<Int>())

    // Iterate through workers
    for (i in quality.indices) {
        highestQualityWorkers.add(wageToQualityRatio[i].second)
        currentTotalQuality += wageToQualityRatio[i].second

        // If we have more than k workers,
        // remove the one with the highest quality
        if (highestQualityWorkers.size > k) {
            currentTotalQuality -= highestQualityWorkers.poll().toDouble()
        }

        // If we have exactly k workers,
        // calculate the total cost and update if it's the minimum
        if (highestQualityWorkers.size == k) {
            totalCost = min(totalCost, currentTotalQuality * wageToQualityRatio[i].first)
        }
    }
    return totalCost
}

private fun main() {

}
