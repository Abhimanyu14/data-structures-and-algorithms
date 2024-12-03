package leetcode.leetcode_1870_minimum_speed_to_arrive_on_time

import kotlin.math.ceil
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
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
private fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
    fun canReach(speed: Int): Boolean {
        var time = 0.0
        dist.forEach {
            time = ceil(time)
            time += it.toDouble() / speed
        }
        return time <= hour
    }

    var right = dist.max()
    if (hour < dist.size) {
        right = max(right.toDouble(), dist.last() / (hour - dist.size - 1)).toInt()
    }
    if (!canReach(right)) {
        return -1
    }
    var left = 1
    while (left < right) {
        val mid = left + ((right - left) / 2)
        if (canReach(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

private fun main() {

}
