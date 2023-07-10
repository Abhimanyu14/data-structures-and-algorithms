package leetcode.leet_2500_to_2599.leet_2511_maximum_enemy_forts_that_can_be_captured

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 174 ms, faster than 66.67%
 * Memory Usage: 36.4 MB, less than 20.00%
 */
private fun captureForts(forts: IntArray): Int {
    var i = 0
    while (i <= forts.lastIndex && forts[i] == 0) {
        i++
    }
    if (i == forts.size) {
        return 0
    }
    var prev = forts[i++]
    var count = 0
    var result = 0
    while (i <= forts.lastIndex) {
        if (forts[i] == 0) {
            count++
        } else {
            if (prev != forts[i]) {
                result = max(result, count)
            }
            prev = forts[i]
            count = 0
        }
        i++
    }
    return result
}

private fun main() {

}
