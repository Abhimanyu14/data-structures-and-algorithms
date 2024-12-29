package leetcode.leetcode_1519_number_of_nodes_in_the_sub_tree_with_the_same_label

import java.util.LinkedList
import java.util.Queue


/**
 * leetcode - https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
 *
 * Using DFS
 *
 * Stats
 * Runtime: 1445 ms, faster than 100.00%
 * Memory Usage: 133 MB, less than 100.00%
 */
private fun countSubTreesUsingDfs(n: Int, edges: Array<IntArray>, labels: String): IntArray {
    val adj: MutableMap<Int?, MutableList<Int>> = mutableMapOf()
    edges.forEach { edge ->
        adj.computeIfAbsent(edge[0]) { _: Int? -> ArrayList() }.add(edge[1])
        adj.computeIfAbsent(edge[1]) { _: Int? -> ArrayList() }.add(edge[0])
    }
    val ans = IntArray(n)
    fun dfs(node: Int, parent: Int): IntArray {
        val nodeCounts = IntArray(26)
        nodeCounts[labels[node] - 'a'] = 1
        adj[node]?.forEach { child ->
            if (child != parent) {
                val childCounts = dfs(child, node)
                childCounts.forEachIndexed { index, childCount ->
                    nodeCounts[index] += childCount
                }
            }
        }
        ans[node] = nodeCounts[labels[node] - 'a']
        return nodeCounts
    }
    dfs(0, -1)
    return ans
}

/**
 * leetcode - https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
 *
 * Using DFS
 *
 * Stats
 * Runtime: 1445 ms, faster than 100.00%
 * Memory Usage: 133 MB, less than 100.00%
 */
private class Solution {
    fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {
        val adj: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
        edges.forEach { edge ->
            adj.computeIfAbsent(edge[0]) { _: Int -> HashSet() }.add(edge[1])
            adj.computeIfAbsent(edge[1]) { _: Int -> HashSet() }.add(edge[0])
        }
        val counts = Array(n) {
            IntArray(26)
        }
        val q: Queue<Int> = LinkedList()
        for (i in 0..<n) {
            counts[i][labels[i] - 'a'] = 1
            if (i != 0 && adj[i]!!.size == 1) {
                q.offer(i)
            }
        }
        while (!q.isEmpty()) {
            val node = q.poll()

            // Each node will have only one element which will be its parent.
            val parent = adj[node]!!.stream().findFirst().get()
            // Remove current node from adjacency list of parent node
            // so current node is not traversed again by parent node.
            // (due to this step, we remove all child nodes from a parent, at end parent node will only have its parent in adjacency list)
            adj[parent]!!.remove(node)

            // Add counts of current node in parent's frequency array.
            for (i in 0..25) {
                counts[parent][i] += counts[node][i]
            }

            // If parent adj size is 1, it has only it's parent in the adjacency list so,
            // it means current node is last child of parent, so we insert it in queue now.
            if (parent != 0 && adj[parent]!!.size == 1) {
                q.offer(parent)
            }
        }
        val ans = IntArray(n)
        for (i in 0..<n) {
            ans[i] = counts[i][labels[i] - 'a']
        }
        return ans
    }
}

private fun main() {

}
