package leetcode.leetcode_983_minimum_cost_for_tickets

/**
 * leetcode - https://leetcode.com/problems/minimum-cost-for-tickets/
 *
 * TODO(Abhi) - To complete using tabulation approach
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */

/**
 * leetcode - https://leetcode.com/problems/minimum-cost-for-tickets/
 *
 * Data Structure - Map
 * Algorithm - Recursion and Dynamic Programming - Memoization
 *
 * Difficulty - Medium
 *
 * Stats
 * 20 ms Beats 40.91%
 * 38.96 MB Beats 28.79%
 *
 * Time -
 * Space -
 */
private fun mincostTicketsUsingMemoization(days: IntArray, costs: IntArray): Int {
    val memo = mutableMapOf<Int, Int>()
    fun calculate(dayIndex: Int): Int {
        memo[dayIndex]?.let {
            return it
        }
        var nextDay = -1
        var nextWeek = -1
        var nextMonth = -1
        for (i in dayIndex..days.lastIndex) {
            if (nextDay == -1 && days[i] >= days[dayIndex] + 1) {
                nextDay = i
            }
            if (nextWeek == -1 && days[i] >= days[dayIndex] + 7) {
                nextWeek = i
            }
            if (days[i] >= days[dayIndex] + 30) {
                nextMonth = i
                break
            }
        }
        val withDayPass = if (nextDay != -1) {
            costs[0] + calculate(nextDay)
        } else {
            costs[0]
        }
        val withWeekPass = if (nextWeek != -1) {
            costs[1] + calculate(nextWeek)
        } else {
            costs[1]
        }
        val withMonthPass = if (nextMonth != -1) {
            costs[2] + calculate(nextMonth)
        } else {
            costs[2]
        }
        memo[dayIndex] = minOf(withDayPass, withWeekPass, withMonthPass)
        return memo[dayIndex]!!
    }
    return calculate(0)
}

/**
 * leetcode - https://leetcode.com/problems/minimum-cost-for-tickets/
 *
 * Data Structure - NA
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time - O(3 ^ N)
 * Space - O(N)
 */
private fun mincostTicketsUsingBruteForce(days: IntArray, costs: IntArray): Int {
    fun calculate(dayIndex: Int): Int {
        var nextDay = -1
        var nextWeek = -1
        var nextMonth = -1
        for (i in dayIndex..days.lastIndex) {
            if (nextDay == -1 && days[i] >= days[dayIndex] + 1) {
                nextDay = i
            }
            if (nextWeek == -1 && days[i] >= days[dayIndex] + 7) {
                nextWeek = i
            }
            if (days[i] >= days[dayIndex] + 30) {
                nextMonth = i
                break
            }
        }
        val withDayPass = if (nextDay != -1) {
            costs[0] + calculate(nextDay)
        } else {
            costs[0]
        }
        val withWeekPass = if (nextWeek != -1) {
            costs[1] + calculate(nextWeek)
        } else {
            costs[1]
        }
        val withMonthPass = if (nextMonth != -1) {
            costs[2] + calculate(nextMonth)
        } else {
            costs[2]
        }
        return minOf(withDayPass, withWeekPass, withMonthPass)
    }
    return calculate(0)
}

private fun recursiveSolution(days: IntArray, costs: IntArray, day: Int, cost: Int): Int {
    if (day > days.last()) {
        return cost
    }
    val nextTravelDay = days.first { it >= day }
    return minOf(
        recursiveSolution(days, costs, nextTravelDay + 1, cost + costs[0]),
        recursiveSolution(days, costs, nextTravelDay + 7, cost + costs[1]),
        recursiveSolution(days, costs, nextTravelDay + 30, cost + costs[2])
    )
}

private fun recursiveSolutionDriver(days: IntArray, costs: IntArray): Int {
    return recursiveSolution(days, costs, 1, 0)
}

private fun mincostTickets1(days: IntArray, costs: IntArray): Int {
    val dp = IntArray(365 + 1) { 0 }
    var i = 1
    while (!days.contains(i)) {
        i++
    }
    dp[i] = minOf(costs[0], costs[1], costs[2])
    i++
    var day: Int
    var week: Int
    var month: Int
    while (i <= 365) {
        dp[i] = if (days.contains(i)) {
            day = costs[0] + dp[i - 1]
            week = if (i - 7 >= 0) {
                costs[1] + dp[i - 7]
            } else {
                costs[1] + 0
            }
            month = if (i - 30 >= 0) {
                costs[2] + dp[i - 30]
            } else {
                costs[2] + 0
            }
            minOf(day, week, month)
        } else {
            dp[i - 1]
        }
        i++
    }
    return dp[365]
}

private fun main() {
}
