package leetcode.leetcode_1700_to_1799.leetcode_1743_restore_the_array_from_adjacent_pairs

/**
 * leetcode - https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
 *
 * Using DFS
 *
 * Stats
 *
 */
private fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
    val edgeNodes = mutableSetOf<Int>()
    val graph = mutableMapOf<Int, MutableSet<Int>>()
    adjacentPairs.forEach {
        if (edgeNodes.contains(it[0])) {
            edgeNodes.remove(it[0])
        } else {
            edgeNodes.add(it[0])
        }
        if (edgeNodes.contains(it[1])) {
            edgeNodes.remove(it[1])
        } else {
            edgeNodes.add(it[1])
        }

        graph.computeIfAbsent(it[0]) {
            mutableSetOf()
        }.add(it[1])
        graph.computeIfAbsent(it[1]) {
            mutableSetOf()
        }.add(it[0])
    }
    val result = mutableListOf<Int>()
    val visited = mutableSetOf<Int>()
    fun dfs(current: Int) {
        visited.add(current)
        result.add(current)
        graph[current]?.forEach {
            if (!visited.contains(it)) {
                dfs(it)
            }
        }
    }
    dfs(edgeNodes.first())
    return result.toIntArray()
}

private fun main() {

}
