package leetcode.leetcode_300_to_399.leetcode_310_minimum_height_trees

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/minimum-height-trees/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
private class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        edges.forEach {
            graph.computeIfAbsent(it[0]) {
                mutableListOf()
            }.add(it[1])
            graph.computeIfAbsent(it[1]) {
                mutableListOf()
            }.add(it[0])
        }

        fun getHeight(root: Int, height: Int, visited: Set<Int>) : Int {
            var maxChildHeight = -1
            graph[root]?.forEach {
                if (!visited.contains(it)) {
                    maxChildHeight = max(maxChildHeight, getHeight(it, height + 1, visited + root))
                }
            }
            return maxChildHeight + 1
        }

        val result = mutableListOf<Int>()
        var minHeight = Int.MAX_VALUE
        var temp1: Int
        repeat(n) {
            temp1 = getHeight(it, 0, setOf(it))
            if (temp1 == minHeight) {
                result.add(it)
            } else if (temp1 < minHeight) {
                minHeight = temp1
                result.clear()
                result.add(it)
            }
        }

        return result
    }
}

private fun main() {

}
