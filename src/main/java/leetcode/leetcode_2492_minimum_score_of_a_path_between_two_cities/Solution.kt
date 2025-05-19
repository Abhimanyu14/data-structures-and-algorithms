package leetcode.leetcode_2492_minimum_score_of_a_path_between_two_cities

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/submissions/1637445512/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google
 */
private fun minScore(n: Int, roads: Array<IntArray>): Int {
    var result = Int.MAX_VALUE
    val graph = Array(n) {
        mutableListOf<Pair<Int, Int>>()
    }
    for ((from, to, distance) in roads) {
        graph[from - 1].add(Pair(to - 1, distance))
        graph[to - 1].add(Pair(from - 1, distance))
    }
    val visited = BooleanArray(n)
    fun dfs(index: Int) {
        visited[index] = true
        graph[index].forEach { (next, dist) ->
            result = min(result, dist)
            if (!visited[next]) {
                dfs(next)
            }
        }
    }
    dfs(0)
    return result
}

private fun main() {

}
