package leetcode.leet_2100_to_2199.leet_2192_all_ancestors_of_a_node_in_a_directed_acyclic_graph

/**
 * leetcode - https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/?envType=daily-question&envId=2024-06-29
 *
 * Using Array and list
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 987 ms, faster than 57.14%
 * Memory Usage: 81 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {
    val dependsOnGraph = Array<MutableList<Int>>(n) {
        mutableListOf()
    }
    edges.forEach { (from, to) ->
        dependsOnGraph[to].add(from)
    }
    val result = MutableList(n) {
        mutableListOf<Int>()
    }
    fun getDependencies(node: Int): List<Int> {
        if (dependsOnGraph[node].isEmpty()) {
            return emptyList()
        }
        if (result[node].isNotEmpty()) {
            return result[node]
        }
        val current = mutableListOf<Int>()
        dependsOnGraph[node].forEach {
            current.add(it)
            current.addAll(getDependencies(it))
        }
        result[node] = current.distinct().sorted().toMutableList()
        return result[node]
    }
    repeat(n) {
        if (result[it].isEmpty()) {
            getDependencies(it)
        }
    }
    return result
}

private fun main() {

}
