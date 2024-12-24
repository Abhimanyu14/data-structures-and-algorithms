package leetcode.leetcode_1396_design_underground_system

/**
 * leetcode - https://leetcode.com/problems/design-underground-system/
 *
 * Data Structure - Map
 * Algorithm - Hashing
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 180 ms, faster than 44.44%
 * Memory Usage: 79.2 MB, less than 11.11%
 *
 * Time -
 * Space -
 */
private class UndergroundSystem() {
    private val checkIn = mutableMapOf<Int, Pair<String, Int>>()
    private val completed = mutableMapOf<Pair<String, String>, Pair<Long, Int>>()

    fun checkIn(id: Int, stationName: String, t: Int) {
        checkIn[id] = Pair(stationName, t)
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val (startStation, time) = checkIn.getOrDefault(id, Pair("", 0))
        val (timeTaken, count) = completed.getOrDefault(Pair(startStation, stationName), Pair(0L, 0))
        completed[Pair(startStation, stationName)] = Pair(timeTaken + t - time + 1, count + 1)
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val (timeTaken, count) = completed.getOrDefault(Pair(startStation, endStation), Pair(0L, 0))
        return timeTaken.toDouble() / count
    }
}

private fun main() {

}
