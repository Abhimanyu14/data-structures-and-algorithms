package leetcode.leetcode_1631_path_with_minimum_effort

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/path-with-minimum-effort/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
private fun minimumEffortPath(heights: Array<IntArray>): Int {
    if (heights.size == 1 && heights[0].size == 1) {
        return 0
    }

    fun getNextNodes(x: Int, y: Int): List<Pair<Int, Int>> {
        return buildList {
            if (x - 1 >= 0) {
                add(Pair(x - 1, y))
            }
            if (y - 1 >= 0) {
                add(Pair(x, y - 1))
            }
            if (x + 1 < heights.size) {
                add(Pair(x + 1, y))
            }
            if (y + 1 < heights[0].size) {
                add(Pair(x, y + 1))
            }
        }
    }

    fun dfs(x: Int, y: Int, visited: Set<Pair<Int, Int>>, effortTillHere: Int, minEffortFoundSoFar: Int): Int {
        if (x == heights.lastIndex && y == heights[0].lastIndex) {
            return effortTillHere
        }
        var result = Int.MAX_VALUE
        getNextNodes(x, y).forEach { (adjX, adjY) ->
            if (!visited.contains(Pair(adjX, adjY))) {
                val effortToNextNode = max(effortTillHere, abs(heights[x][y] - heights[adjX][adjY]))
                if (effortToNextNode < minEffortFoundSoFar) {
                    result = min(result, dfs(adjX, adjY, visited + Pair(x, y), effortToNextNode, result))
                }
            }
        }
        return result
    }
    return dfs(0, 0, setOf(), 0, Int.MAX_VALUE)
}

private fun main() {

}
