package leetcode.leetcode_2101_detonate_the_maximum_bombs

import kotlin.math.max
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * leetcode - https://leetcode.com/problems/detonate-the-maximum-bombs/
 *
 * Data Structure - Graph
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N^3)
 * Space - O(N^2)
 *
 * Companies - Amazon, Google, Meta
 */
private fun maximumDetonationUsingBfs(bombs: Array<IntArray>): Int {
    var result = 0
    val graph = Array(bombs.size) {
        mutableListOf<Int>()
    }
    val visited = mutableSetOf<Int>()
    val queue = ArrayDeque<Int>()
    for (i in bombs.indices) {
        for (j in bombs.indices) {
            if (i != j) {
                val (x1, y1, d1) = bombs[i]
                val (x2, y2, _) = bombs[j]
                val distance = sqrt((x2 - x1).toDouble().pow(2) + (y2 - y1).toDouble().pow(2))
                if (distance <= d1.toDouble()) {
                    graph[i].add(j)
                }
            }
        }
    }
    for (i in bombs.indices) {
        visited.clear()
        queue.addLast(i)
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            if (visited.contains(current)) {
                continue
            }
            visited.add(current)
            graph[current].forEach {
                if (!visited.contains(it)) {
                    queue.addLast(it)
                }
            }
        }
        result = max(result, visited.size)
    }
    return result
}

private fun maximumDetonationUsingDfs(bombs: Array<IntArray>): Int {
    val graph = mutableMapOf<Int, List<Int>>()
    val adjacent = mutableListOf<Int>()
    bombs.forEachIndexed { index, bomb ->
        adjacent.clear()
        bombs.forEachIndexed { innerIndex, innerBomb ->
            if (index != innerIndex) {
                if ((bomb[2] * bomb[2]).toDouble() >= ((innerBomb[0] - bomb[0]).toFloat()
                        .pow(2) + (innerBomb[1] - bomb[1]).toFloat().pow(2)).toDouble()
                ) {
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
