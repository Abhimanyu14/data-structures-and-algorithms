package leetcode.leetcode_797_all_paths_from_source_to_target

import java.util.LinkedList

/**
 * leetcode - https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 * Using backtracking - recursion
 *
 * Stats
 * Runtime: 321 ms, faster than 84.00%
 * Memory Usage: 39.8 MB, less than 98.00%
 */
private fun allPathsSourceTargetUsingBacktracking(graph: Array<IntArray>): List<List<Int>> {
    val results: MutableList<List<Int>> = ArrayList()
    // Use LinkedList for fast access to the tail element
    val path = LinkedList<Int>()
    path.addLast(0)

    fun backtrack(currNode: Int, path: LinkedList<Int>) {
        if (currNode == graph.lastIndex) {
            // Note: one should make a deep copy of the path
            results.add(ArrayList(path))
            return
        }
        // explore the neighbor nodes one after another.
        for (nextNode in graph[currNode]) {
            // mark the choice, before backtracking.
            path.addLast(nextNode)
            backtrack(nextNode, path)
            // remove the previous choice, to try the next choice
            path.removeLast()
        }
    }
    // kick of the backtracking, starting from the source (node 0)
    backtrack(0, path)
    return results
}

/**
 * leetcode - https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 * Using dynamic programming
 *
 * Stats
 * Runtime: 355 ms, faster than 82.00%
 * Memory Usage: 42.4 MB, less than 82.00%
 */
private fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
    fun recursion(graph: Array<IntArray>, pos: Int): MutableList<MutableList<Int>> {
        if (pos == graph.lastIndex) {
            return mutableListOf(mutableListOf(pos))
        }
        if (graph[pos].isEmpty()) {
            return mutableListOf()
        }
        val result: MutableList<MutableList<Int>> = mutableListOf()
        graph[pos].forEach { currentPos ->
            recursion(graph, currentPos).forEach {
                it.add(0, pos)
                result.add(it)
            }
        }
        return result
    }

    return recursion(graph, 0)
}

private fun main() {

}
