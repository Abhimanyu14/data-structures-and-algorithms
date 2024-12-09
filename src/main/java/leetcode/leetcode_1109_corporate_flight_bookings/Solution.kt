package leetcode.leetcode_1109_corporate_flight_bookings

/**
 * leetcode - https://leetcode.com/problems/corporate-flight-bookings/
 *
 * Data Structure - Array
 * Algorithm - Prefix Sum
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 21 ms, faster than 75.00%
 * Memory Usage: 65.8 MB, less than 80.00%
 *
 * Time -
 * Space -
 */
private fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
    val result = IntArray(n)
    val prefixSum = IntArray(n + 1)
    for (i in bookings.indices) {
        prefixSum[bookings[i][0] - 1] += bookings[i][2]
        prefixSum[bookings[i][1]] -= bookings[i][2]
    }
    for (i in 1..prefixSum.lastIndex) {
        prefixSum[i] += prefixSum[i - 1]
    }
    repeat(n) {
        result[it] = prefixSum[it]
    }
    return result
}

private fun main() {

}
