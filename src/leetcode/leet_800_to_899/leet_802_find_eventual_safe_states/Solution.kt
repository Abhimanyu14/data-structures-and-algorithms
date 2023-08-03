package leetcode.leet_800_to_899.leet_802_find_eventual_safe_states

/**
 * leetcode - https://leetcode.com/problems/find-eventual-safe-states/
 *
 * Using DFS
 *
 * Stats
 * Runtime: 1186 ms, faster than 8.70%
 * Memory Usage: 64 MB, less than 69.57%
 */
fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
    val set = sortedSetOf<Int>()
    val visited = mutableSetOf<Int>()

    fun getSafeNodes() {

    }
    graph.forEachIndexed { index, value ->
        if (value.isEmpty()) {
            set.add(index)
        }
    }
    var updated = true
    var flag: Boolean
    while (updated) {
        updated = false
        for (i in graph.indices) {
            if (!set.contains(i)) {
                flag = true
                for (j in graph[i].indices) {
                    if (!set.contains(graph[i][j])) {
                        flag = false
                        break
                    }
                }
                if (flag) {
                    set.add(i)
                    updated = true
                }
            }
        }
    }
    return set.toList()
}

fun eventualSafeNodesUsingSet(graph: Array<IntArray>): List<Int> {
    val set = sortedSetOf<Int>()
    graph.forEachIndexed { index, value ->
        if (value.isEmpty()) {
            set.add(index)
        }
    }
    var updated = true
    var flag: Boolean
    while (updated) {
        updated = false
        for (i in graph.indices) {
            if (!set.contains(i)) {
                flag = true
                for (j in graph[i].indices) {
                    if (!set.contains(graph[i][j])) {
                        flag = false
                        break
                    }
                }
                if (flag) {
                    set.add(i)
                    updated = true
                }
            }
        }
    }
    return set.toList()
}

private fun main() {

}
