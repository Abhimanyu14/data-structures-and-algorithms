package leetcode.leetcode_319_bulb_switcher

import kotlin.math.sqrt

/**
 * leetcode - https://leetcode.com/problems/bulb-switcher/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Maths
 *
 * Difficulty - Medium
 *
 * Stats
 *
 *
 * Time - O(1)
 * Space - O(1)
 *
 * Companies - Google
 */
private fun bulbSwitch(n: Int): Int {
    return sqrt(n.toDouble()).toInt()
}

/**
 * leetcode - https://leetcode.com/problems/bulb-switcher/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [BooleanArray]
 * Algorithm - Simulation
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(N ^ 2)
 * Space - O(N)
 *
 * Companies - Google
 */
private fun bulbSwitchUsingBruteForce(n: Int): Int {
    val bulbs = BooleanArray(n)
    for (i in 0..<n) {
        for (j in i..<n step (i + 1)) {
            bulbs[j] = !bulbs[j]
        }
    }
    return bulbs.count { it }
}

private fun main() {

}
