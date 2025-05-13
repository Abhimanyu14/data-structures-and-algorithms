package leetcode.leetcode_2008_maximum_earnings_from_taxi

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-earnings-from-taxi/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [LongArray]
 * Algorithm - Dynamic Programming
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Meta
 */

private fun maxTaxiEarnings(n: Int, rides: Array<IntArray>): Long {
    val sortedRides = rides.sortedBy { it[0] }
    val dp = LongArray(rides.size)
    dp[dp.lastIndex] = sortedRides[sortedRides.lastIndex][1].toLong() - sortedRides[sortedRides.lastIndex][0] +
            sortedRides[sortedRides.lastIndex][2]

    fun getNextIndex(currentEnd: Int): Int {
        var left = 0
        var right = sortedRides.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (sortedRides[mid][0] >= currentEnd) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    for (i in (sortedRides.lastIndex - 1) downTo 0) {
        var current = sortedRides[i][1].toLong() - sortedRides[i][0] + sortedRides[i][2]
        val nextIndex = getNextIndex(sortedRides[i][1])
        if (nextIndex <= sortedRides.lastIndex) {
            current += dp[nextIndex]
        }
        dp[i] = max(dp[i + 1], current)
    }
    return dp[0]
}

/**
 * leetcode - https://leetcode.com/problems/maximum-earnings-from-taxi/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [LongArray]
 * Algorithm - Dynamic Programming
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * log(N))
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun maxTaxiEarningsUsingLinearSearch(n: Int, rides: Array<IntArray>): Long {
    val sortedRides = rides.sortedBy { it[0] }
    val dp = LongArray(rides.size)
    dp[dp.lastIndex] =
        sortedRides[sortedRides.lastIndex][1].toLong() - sortedRides[sortedRides.lastIndex][0] + sortedRides[sortedRides.lastIndex][2]
    for (i in (sortedRides.lastIndex - 1) downTo 0) {
        var index = i
        var current = sortedRides[index][1].toLong() - sortedRides[index][0] + sortedRides[index][2]
        val currentEnd = sortedRides[index][1]
        index++
        while (index <= sortedRides.lastIndex && sortedRides[index][0] < currentEnd) {
            index++
        }
        if (index <= sortedRides.lastIndex) {
            current += dp[index]
        }
        dp[i] = max(dp[i + 1], current)
    }
    return dp[0]
}


private fun main() {

}
