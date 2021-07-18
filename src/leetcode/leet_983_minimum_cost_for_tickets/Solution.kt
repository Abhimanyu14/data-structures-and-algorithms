package leetcode.leet_983_minimum_cost_for_tickets

fun recursiveSolution(days: IntArray, costs: IntArray, day: Int, cost: Int): Int {
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

fun recursiveSolutionDriver(days: IntArray, costs: IntArray): Int {
    return recursiveSolution(days, costs, 1, 0)
}

fun mincostTickets(days: IntArray, costs: IntArray): Int {
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

fun main() {
    val days = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31)
    val costs = intArrayOf(2, 7, 15)

    // val result = recursiveSolutionDriver(days, costs)
    val result = mincostTickets(days, costs)
    println(result)
}
