package leetcode.leet_1900_to_1999.leet_1971_find_if_path_exists_in_graph

import java.util.LinkedList
import java.util.Queue

/**
 * leetcode - https://leetcode.com/problems/find-if-path-exists-in-graph/
 *
 * Using BFS
 * Linked List
 * Queue - offer(), poll()
 * Map - computeIfAbsent(), getOrDefault()
 *
 * Stats
 * Runtime: 2646 ms, faster than 19.30%
 * Memory Usage: 287.2 MB, less than 5.26%
 */
private fun validPathUsingBFS(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    // Source is same as destination
    if (source == destination) {
        return true
    }

    // Empty graph
    if (edges.isEmpty()) {
        return false
    }

    // Create the graph
    val graph = mutableMapOf<Int, MutableList<Int>>()
    edges.forEach { (a, b) ->
        graph.computeIfAbsent(a) {
            mutableListOf()
        }.add(b)
        graph.computeIfAbsent(b) {
            mutableListOf()
        }.add(a)
    }
    println(graph)

    // Visited flag
    val seen = BooleanArray(n)
    seen[source] = true

    // Queue
    val queue: Queue<Int> = LinkedList()
    queue.offer(source)

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current == destination) {
            return true
        }
        for (next in graph.getOrDefault(current, mutableListOf())) {
            if (!seen[next]) {
                seen[next] = true
                queue.offer(next)
            }
        }
    }
    return false
}

/**
 * leetcode - https://leetcode.com/problems/find-if-path-exists-in-graph/
 *
 * Using DFS
 * Linked List
 * Queue - offer(), poll()
 * Map - computeIfAbsent(), getOrDefault()
 *
 * Stats
 * Runtime: 2742 ms, faster than 15.79%
 * Memory Usage: 280.5 MB, less than 5.26%
 */
private fun validPathUsingDFS(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    // Source is same as destination
    if (source == destination) {
        return true
    }

    // Empty graph
    if (edges.isEmpty()) {
        return false
    }

    // Create the graph
    val graph = mutableMapOf<Int, MutableList<Int>>()
    edges.forEach { (a, b) ->
        graph.computeIfAbsent(a) {
            mutableListOf()
        }.add(b)
        graph.computeIfAbsent(b) {
            mutableListOf()
        }.add(a)
    }
    println(graph)

    // Visited flag
    val seen = BooleanArray(n)
    seen[source] = true

    // Stack
    val stack = ArrayDeque<Int>()
    stack.addLast(source)

    while (stack.isNotEmpty()) {
        val current = stack.removeLast()
        if (current == destination) {
            return true
        }
        for (next in graph.getOrDefault(current, mutableListOf())) {
            if (!seen[next]) {
                seen[next] = true
                stack.addLast(next)
            }
        }
    }
    return false
}

/**
 * leetcode - https://leetcode.com/problems/find-if-path-exists-in-graph/
 *
 * Using DSU (Disjoint Set Union) aka Union Find
 * Linked List
 * Queue - offer(), poll()
 * Map - computeIfAbsent(), getOrDefault()
 *
 * Stats
 * Runtime: 2742 ms, faster than 15.79%
 * Memory Usage: 280.5 MB, less than 5.26%
 */
private class UnionFind(
    val n: Int,
) {
    val root = IntArray(n) { it }
    val rank = IntArray(n)

    fun find(x: Int): Int {
        if (root[x] != x) {
            root[x] = find(root[x])
        }
        return root[x]
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)
    }
}

private fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    // Source is same as destination
    if (source == destination) {
        return true
    }

    // Empty graph
    if (edges.isEmpty()) {
        return false
    }

    // Create the graph
    val graph = mutableMapOf<Int, MutableList<Int>>()
    edges.forEach { (a, b) ->
        graph.computeIfAbsent(a) {
            mutableListOf()
        }.add(b)
        graph.computeIfAbsent(b) {
            mutableListOf()
        }.add(a)
    }
    println(graph)

    // Visited flag
    val seen = BooleanArray(n)
    seen[source] = true

    // Stack
    val stack = ArrayDeque<Int>()
    stack.addLast(source)

    while (stack.isNotEmpty()) {
        val current = stack.removeLast()
        if (current == destination) {
            return true
        }
        for (next in graph.getOrDefault(current, mutableListOf())) {
            if (!seen[next]) {
                seen[next] = true
                stack.addLast(next)
            }
        }
    }
    return false
}

private fun main() {

}
