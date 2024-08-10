package leetcode.leet_900_to_999.leet_959_regions_cut_by_slashes

import java.util.Arrays



/**
 * leetcode - https://leetcode.com/problems/regions-cut-by-slashes/?envType=daily-question&envId=2024-08-10
 *
 * TODO(Abhi) - To complete
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
private fun regionsBySlashes(grid: Array<String>): Int {
    val gridSize = grid.size
    val pointsPerSide = gridSize + 1
    val totalPoints = pointsPerSide * pointsPerSide

    // Initialize disjoint set data structure
    val parentArray = IntArray(totalPoints)
    Arrays.fill(parentArray, -1)

    // Connect border points
    for (i in 0 until pointsPerSide) {
        for (j in 0 until pointsPerSide) {
            if (i == 0 || j == 0 || i == pointsPerSide - 1 || j == pointsPerSide - 1
            ) {
                val point = i * pointsPerSide + j
                parentArray[point] = 0
            }
        }
    }

    // Set the parent of the top-left corner to itself
    parentArray[0] = -1
    var regionCount = 1 // Start with one region (the border)

    // Process each cell in the grid
    for (i in 0 until gridSize) {
        for (j in 0 until gridSize) {
            // Treat each slash as an edge connecting two points
            if (grid[i][j] == '/') {
                val topRight = i * pointsPerSide + (j + 1)
                val bottomLeft = (i + 1) * pointsPerSide + j
                regionCount += union(parentArray, topRight, bottomLeft)
            } else if (grid[i][j] == '\\') {
                val topLeft = i * pointsPerSide + j
                val bottomRight = (i + 1) * pointsPerSide + (j + 1)
                regionCount += union(parentArray, topLeft, bottomRight)
            }
        }
    }

    return regionCount
}

// Find the parent of a set
private fun find(parentArray: IntArray, node: Int): Int {
    if (parentArray[node] == -1) return node

    return find(parentArray, parentArray[node]).also { parentArray[node] = it }
}

// Union two sets and return 1 if a new region is formed, 0 otherwise
private fun union(parentArray: IntArray, node1: Int, node2: Int): Int {
    val parent1 = find(parentArray, node1)
    val parent2 = find(parentArray, node2)

    if (parent1 == parent2) {
        return 1 // Nodes are already in the same set, new region formed
    }

    parentArray[parent2] = parent1 // Union the sets
    return 0 // No new region formed
}

private fun main() {

}
