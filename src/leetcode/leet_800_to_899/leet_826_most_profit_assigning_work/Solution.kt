package leetcode.leet_800_to_899.leet_826_most_profit_assigning_work

import java.util.Arrays
import kotlin.math.max


/**
 * leetcode - https://leetcode.com/problems/most-profit-assigning-work/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun maxProfitAssignment(
    difficulty: IntArray,
    profit: IntArray,
    worker: IntArray,
): Int {
    // Find maximum ability in the worker array.
    val maxAbility = Arrays.stream(worker).max().asInt
    val jobs = IntArray(maxAbility + 1)

    for (i in difficulty.indices) {
        if (difficulty[i] <= maxAbility) {
            jobs[difficulty[i]] =
                max(jobs[difficulty[i]].toDouble(), profit[i].toDouble()).toInt()
        }
    }

    // Take maxima of prefixes.
    for (i in 1..maxAbility) {
        jobs[i] = max(jobs[i].toDouble(), jobs[i - 1].toDouble()).toInt()
    }

    var netProfit = 0
    for (ability in worker) {
        netProfit += jobs[ability]
    }
    return netProfit
}

private fun main() {

}
