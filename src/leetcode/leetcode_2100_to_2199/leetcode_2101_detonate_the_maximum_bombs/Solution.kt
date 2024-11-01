package leetcode.leetcode_2100_to_2199.leetcode_2101_detonate_the_maximum_bombs

import kotlin.math.max
import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/detonate-the-maximum-bombs/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
private fun maximumDetonation(bombs: Array<IntArray>): Int {
    val graph = mutableMapOf<Int, List<Int>>()
    val adjacent = mutableListOf<Int>()
    bombs.forEachIndexed { index, bomb ->
        adjacent.clear()
        bombs.forEachIndexed { innerIndex, innerBomb ->
            if (index != innerIndex) {
                if ((bomb[2] * bomb[2]).toDouble() >= ((innerBomb[0] - bomb[0]).toFloat().pow(2) + (innerBomb[1] - bomb[1]).toFloat().pow(2)).toDouble()) {
                    adjacent.add(innerIndex)
                }
            }
        }
        graph[index] = adjacent.toList()
    }

    fun dfs(start: Int): Int {
        val visited = mutableSetOf<Int>()
        val stack = ArrayDeque<Int>()
        visited.add(start)
        stack.add(start)
        while (stack.isNotEmpty()) {
            graph[stack.removeLast()]?.forEach {
                if (!visited.contains(it)) {
                    visited.add(it)
                    stack.addLast(it)
                }
            }
        }
        return visited.size
    }
    var result = 0
    graph.forEach {
        result = max(result, dfs(it.key))
    }

    return result
}

private fun main() {

}
