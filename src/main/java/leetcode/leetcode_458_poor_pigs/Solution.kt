package leetcode.leetcode_458_poor_pigs

import kotlin.math.ceil
import kotlin.math.ln

/**
 * leetcode - https://leetcode.com/problems/poor-pigs/
 *
 * TODO(Abhi) - To revisit
 *
 * Using qubit
 *
 * Note: Leetcode solution does not work
 * It's because of floating point error, you can subtract a very small number (e.g. 0.0000001)
 * from the result of the logarithm before applying the ceiling function.
 *
 *
 * Stats
 * Runtime: 119 ms, faster than 66.67%
 * Memory Usage: 33.3 MB, less than 66.67%
 */
private fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
    val states = minutesToTest / minutesToDie + 1
    return ceil((ln((buckets.toDouble())) / (ln(states.toDouble()))) - 0.0000001).toInt()
}

private fun main() {

}
