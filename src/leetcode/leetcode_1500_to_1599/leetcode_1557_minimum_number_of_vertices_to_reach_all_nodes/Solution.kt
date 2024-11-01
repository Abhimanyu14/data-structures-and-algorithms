package leetcode.leetcode_1500_to_1599.leetcode_1557_minimum_number_of_vertices_to_reach_all_nodes

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 *
 * Using set
 *
 * Stats
 * Runtime: 666 ms, faster than 95.00%
 * Memory Usage: 97 MB, less than 90.00%
 */
private fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
    val result = mutableSetOf<Int>()
    repeat(n) {
        result.add(it)
    }
    edges.forEach {
        if (result.contains(it[1])) {
            result.remove(it[1])
        }
    }
    return result.toList()
}

private fun main() {

}
