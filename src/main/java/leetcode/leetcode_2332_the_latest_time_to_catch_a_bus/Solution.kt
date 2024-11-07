package leetcode.leetcode_2332_the_latest_time_to_catch_a_bus

/**
 * leetcode - https://leetcode.com/problems/the-latest-time-to-catch-a-bus/
 * Using
 *
 * Stats
 * Runtime: 1075 ms, faster than 100.00%
 * Memory Usage: 79.2 MB, less than 100.00%
 */
private fun latestTimeCatchTheBus(buses: IntArray, passengers: IntArray, capacity: Int): Int {
    buses.sort()
    passengers.sort()

    var pos = -1
    var count = 1
    buses.forEach {
        count = 1
        while (count <= capacity && pos < passengers.lastIndex && passengers[pos + 1] <= it) {
            count++
            pos++
        }
    }
    if (pos < 0 || (count <= capacity && buses.last() > passengers[pos])) {
        return buses[buses.lastIndex]
    }
    while (pos > 0 && (passengers[pos] == passengers[pos - 1] + 1)) {
        pos--
    }
    return passengers[pos] - 1
}

private fun main() {

}
