package leetcode.leetcode_851_loud_and_rich

/**
 * leetcode - https://leetcode.com/problems/loud-and-rich/?envType=problem-list-v2&envId=topological-sort
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Graph, [IntArray], [Array], [ArrayDeque] (Stack)
 * Algorithm - DFS
 *
 * Difficulty -
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun loudAndRich(richer: Array<IntArray>, quiet: IntArray): IntArray {
    val result = IntArray(quiet.size)
    val graph = Array(quiet.size) {
        mutableListOf<Int>()
    }
    for ((to, from) in richer) {
        graph[from].add(to)
    }
    val visited = BooleanArray(quiet.size)
    fun dfs(current: Int): Int {
        visited[current] = true
        var candidate = current
        graph[current].forEach {
            val newCandidate = if (visited[it]) {
                result[it]
            } else {
                dfs(it)
            }
            if (quiet[newCandidate] < quiet[candidate]) {
                candidate = newCandidate
            }
        }
        result[current] = candidate
        return candidate
    }
    for (i in quiet.indices) {
        if (!visited[i]) {
            dfs(i)
        }
    }
    return result
}

private fun main() {

}
