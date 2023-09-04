package leetcode.leet_2000_to_2099.leet_2087_minimum_cost_homecoming_of_a_robot_in_a_grid

/**
 * leetcode - https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/
 *
 * Using loops
 *
 * Stats
 * Runtime: 608 ms, faster than 100.00%
 * Memory Usage: 67.4 MB, less than 100.00%
 */
private fun minCost(startPos: IntArray, homePos: IntArray, rowCosts: IntArray, colCosts: IntArray): Int {
    var result = 0

    // Row cost
    if (startPos[0] < homePos[0]) {
        for (i in (startPos[0] + 1)..homePos[0]) {
            result += rowCosts[i]
        }
    } else if (startPos[0] > homePos[0]) {
        for (i in (startPos[0] - 1) downTo homePos[0]) {
            result += rowCosts[i]
        }
    }

    // Column cost
    if (startPos[1] < homePos[1]) {
        for (i in (startPos[1] + 1)..homePos[1]) {
            result += colCosts[i]
        }
    } else if (startPos[1] > homePos[1]) {
        for (i in (startPos[1] - 1) downTo homePos[1]) {
            result += colCosts[i]
        }
    }

    return result
}

private fun main() {

}
