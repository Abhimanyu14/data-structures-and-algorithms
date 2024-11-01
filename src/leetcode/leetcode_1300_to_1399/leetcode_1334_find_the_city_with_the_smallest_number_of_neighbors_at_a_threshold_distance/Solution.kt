package leetcode.leetcode_1300_to_1399.leetcode_1334_find_the_city_with_the_smallest_number_of_neighbors_at_a_threshold_distance

import java.util.Arrays
import kotlin.math.min


/**
 * leetcode - https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/?envType=daily-question&envId=2024-07-26
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
    // Floyd-Warshall algorithm to compute the shortest paths between all pairs of cities
    fun floyd(n: Int, distanceMatrix: Array<IntArray>) {
        // Update distances for each intermediate city
        for (k in 0..<n) {
            for (i in 0..<n) {
                for (j in 0..<n) {
                    // Update the shortest path from i to j through k
                    distanceMatrix[i][j] = min(
                        distanceMatrix[i][j].toDouble(),
                        (distanceMatrix[i][k] + distanceMatrix[k][j]).toDouble()
                    ).toInt()
                }
            }
        }
    }

    // Determine the city with the fewest number of reachable cities within the distance threshold
    fun getCityWithFewestReachable(
        n: Int,
        distanceMatrix: Array<IntArray>,
        distanceThreshold: Int,
    ): Int {
        var cityWithFewestReachable = -1
        var fewestReachableCount = n

        // Count number of cities reachable within the distance threshold for each city
        for (i in 0..<n) {
            var reachableCount = 0
            for (j in 0..<n) {
                if (i == j) {
                    continue
                } // Skip self

                if (distanceMatrix[i][j] <= distanceThreshold) {
                    reachableCount++
                }
            }
            // Update the city with the fewest reachable cities
            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount
                cityWithFewestReachable = i
            }
        }
        return cityWithFewestReachable
    }

    // Large value to represent infinity
    val INF = 1e9.toInt() + 7
    // Distance matrix to store shortest paths between all pairs of cities
    val distanceMatrix = Array(n) { IntArray(n) }

    // Initialize distance matrix
    for (i in 0..<n) {
        Arrays.fill(distanceMatrix[i], INF) // Set all distances to infinity
        distanceMatrix[i][i] = 0 // Distance to itself is zero
    }

    // Populate the distance matrix with initial edge weights
    for (edge in edges) {
        val start = edge[0]
        val end = edge[1]
        val weight = edge[2]
        distanceMatrix[start][end] = weight
        distanceMatrix[end][start] = weight // For undirected graph
    }

    // Compute the shortest paths using Floyd-Warshall algorithm
    floyd(n, distanceMatrix)

    // Find the city with the fewest number of reachable cities within the distance threshold
    return getCityWithFewestReachable(n, distanceMatrix, distanceThreshold)
}

private fun main() {

}
