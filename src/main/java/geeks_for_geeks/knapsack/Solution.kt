package geeks_for_geeks.knapsack

import data_structures.print2DArray
import kotlin.math.max

/**
 * link - https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 */
private fun bruteForceSolution(values: IntArray, weights: IntArray, capacity: Int, count: Int): Int {
    if (capacity == 0 || count == 0) {
        return 0
    }
    if (weights[count - 1] > capacity) {
        return bruteForceSolution(values, weights, capacity, count - 1)
    }
    return max(
        values[count - 1] + bruteForceSolution(values, weights, capacity - weights[count - 1], count - 1),
        bruteForceSolution(values, weights, capacity, count - 1)
    )
}

/**
 * link - https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 */
private fun dynamicProgrammingSolution(values: IntArray, weights: IntArray, capacity: Int, count: Int): Int {
    val dp = Array(count + 1) { Array(capacity + 1) { 0 } }
    print2DArray(dp)

    // Build table dp[][] in bottom up manner
    for (i in 0..count) {
        for (w in 0..capacity) {
            dp[i][w] = if (i == 0 || w == 0) {
                0
            } else if (weights[i - 1] <= w) {
                max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w])
            } else {
                dp[i - 1][w]
            }
        }
    }
    println()
    print2DArray(dp)
    println()
    return dp[count][capacity]
}

// TODO-Implement other solutions

private fun main() {
    val result = dynamicProgrammingSolution(intArrayOf(60, 100, 120), intArrayOf(10, 20, 30), 50, 3)
    println(result)
}
