package leetcode.leet_2300_to_2399.leet_2391_minimum_amount_of_time_to_collect_garbage

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 529 ms, faster than 80.00%
 * Memory Usage: 83.3 MB, less than 40.00%
 */
private fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
    var result = 0
    var m = -1
    var p = -1
    var g = -1
    for (i in garbage.lastIndex downTo 0) {
        garbage[i].forEach {
            if (m == -1 && it == 'M') {
                m = i - 1
            }
            if (p == -1 && it == 'P') {
                p = i - 1
            }
            if (g == -1 && it == 'G') {
                g = i - 1
            }
        }
        result += garbage[i].length
    }
    var temp = 0
    for (i in 0..max(m, max(p, g))) {
        temp += travel[i]
        if (m == i) {
            result += temp
        }
        if (p == i) {
            result += temp
        }
        if (g == i) {
            result += temp
        }
    }
    return result
}

private fun main() {

}
