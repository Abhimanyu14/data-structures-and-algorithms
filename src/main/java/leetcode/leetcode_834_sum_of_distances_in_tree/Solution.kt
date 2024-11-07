package leetcode.leetcode_834_sum_of_distances_in_tree

/**
 * leetcode - https://leetcode.com/problems/sum-of-distances-in-tree/
 *
 * TODO-Abhi: To revisit
 *
 * Using
 *
 * Stats
 *
 */
private fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
    val graph = mutableMapOf<Int, MutableList<Int>>()
    edges.forEach { (from, to) ->
        graph.getOrPut(from, { mutableListOf() }) += to
        graph.getOrPut(to, { mutableListOf() }) += from
    }
    val counts = IntArray(n) { 1 }
    val sums = IntArray(n) { 0 }
    fun distSum(pos: Int, visited: Int) {
        graph[pos]?.forEach {
            if (it != visited) {
                distSum(it, pos)
                counts[pos] += counts[it]
                sums[pos] += counts[it] + sums[it]
            }
        }
    }
    fun dfs(pos: Int, visited: Int) {
        graph[pos]?.forEach {
            if (it != visited) {
                sums[it] = sums[pos] - counts[it] + (n - counts[it])
                dfs(it, pos)
            }
        }
    }
    distSum(0, -1)
    dfs(0, -1)
    return sums
}

private fun main() {

}
