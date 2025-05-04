package leetcode.leetcode_871_minimum_number_of_refueling_stops

import java.util.PriorityQueue
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-refueling-stops/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [PriorityQueue]
 * Algorithm - Heap
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Google
 */
private fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
    if (stations.isEmpty()) {
        return if (startFuel >= target) {
            0
        } else {
            -1
        }
    }
    var result = 0
    var current = startFuel
    var index = 0
    val maxHeap = PriorityQueue<Int> { a, b ->
        b - a
    }
    while (current < target) {
        while (index <= stations.lastIndex && current >= stations[index][0]) {
            maxHeap.offer(stations[index][1])
            index++
        }
        if (maxHeap.isEmpty()) {
            return -1
        }
        result++
        current += maxHeap.poll()
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-refueling-stops/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Dynamic Programming - Memoization
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(2 ^ N)
 * Space - O(2 ^ N)
 *
 * Companies - Google
 */
private fun minRefuelStopsUsingMemoization(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
    if (stations.isEmpty()) {
        return if (startFuel >= target) {
            0
        } else {
            -1
        }
    }
    val cache = mutableMapOf<Triple<Int, Int, Int>, Int>()
    fun canReach(stationIndex: Int, fuelRemaining: Int, refillsCount: Int): Int {
        cache[Triple(stationIndex, fuelRemaining, refillsCount)]?.let {
            return it
        }
        if (fuelRemaining < 0) {
            cache[Triple(stationIndex, fuelRemaining, refillsCount)] = Int.MAX_VALUE
            return cache[Triple(stationIndex, fuelRemaining, refillsCount)]!!
        }
        if (target - stations[stationIndex][0] <= fuelRemaining) {
            cache[Triple(stationIndex, fuelRemaining, refillsCount)] = refillsCount
            return cache[Triple(stationIndex, fuelRemaining, refillsCount)]!!
        }
        if (target - stations[stationIndex][0] <= fuelRemaining + stations[stationIndex][1]) {
            cache[Triple(stationIndex, fuelRemaining, refillsCount)] = refillsCount + 1
            return cache[Triple(stationIndex, fuelRemaining, refillsCount)]!!
        }
        if (stationIndex == stations.lastIndex) {
            cache[Triple(stationIndex, fuelRemaining, refillsCount)] = Int.MAX_VALUE
            return cache[Triple(stationIndex, fuelRemaining, refillsCount)]!!
        }
        cache[Triple(stationIndex, fuelRemaining, refillsCount)] = min(
            canReach(
                stationIndex + 1,
                fuelRemaining - (stations[stationIndex + 1][0] - stations[stationIndex][0]),
                refillsCount
            ),
            canReach(
                stationIndex + 1,
                fuelRemaining - (stations[stationIndex + 1][0] - stations[stationIndex][0]) + stations[stationIndex][1],
                refillsCount + 1
            )
        )
        return cache[Triple(stationIndex, fuelRemaining, refillsCount)]!!
    }

    val result = canReach(0, startFuel - stations[0][0], 0)
    return if (result == Int.MAX_VALUE) {
        -1
    } else {
        result
    }
}

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-refueling-stops/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(2 ^ N)
 * Space - O(2 ^ N)
 *
 * Companies - Google
 */
private fun minRefuelStopsUsingBruteForce(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
    if (stations.isEmpty()) {
        return if (startFuel >= target) {
            0
        } else {
            -1
        }
    }
    var result = Int.MAX_VALUE
    fun canReach(stationIndex: Int, fuelRemaining: Int, refillsCount: Int) {
        if (fuelRemaining < 0) {
            return
        }
        if (target - stations[stationIndex][0] <= fuelRemaining) {
            result = min(result, refillsCount)
            return
        }
        if (target - stations[stationIndex][0] <= fuelRemaining + stations[stationIndex][1]) {
            result = min(result, refillsCount + 1)
            return
        }
        if (stationIndex == stations.lastIndex) {
            return
        }
        canReach(
            stationIndex + 1,
            fuelRemaining - (stations[stationIndex + 1][0] - stations[stationIndex][0]),
            refillsCount,
        )
        canReach(
            stationIndex + 1,
            fuelRemaining - (stations[stationIndex + 1][0] - stations[stationIndex][0]) + stations[stationIndex][1],
            refillsCount + 1,
        )
    }
    canReach(0, startFuel - stations[0][0], 0)
    return if (result == Int.MAX_VALUE) {
        -1
    } else {
        result
    }
}

private fun main() {

}
