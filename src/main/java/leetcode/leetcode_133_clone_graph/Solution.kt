package leetcode.leetcode_133_clone_graph

/**
 * leetcode - https://leetcode.com/problems/clone-graph/
 *
 * Data Structure - Graph
 * Algorithm - DFS
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 218 ms, faster than 18.18%
 * Memory Usage: 37.3 MB, less than 80.52%
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun cloneGraph(node: Node?): Node? {
    if (node == null) {
        return null
    }
    val graph = mutableMapOf<Int, Node?>()
    fun dfs(current: Node) {
        graph[current.`val`] = Node(current.`val`)
        for (neighbor in current.neighbors) {
            if (!graph.contains(neighbor!!.`val`)) {
                dfs(neighbor)
            }
            graph[current.`val`]!!.neighbors.add(graph[neighbor.`val`]!!)
        }
    }
    dfs(node)
    return graph[node.`val`]!!
}

private fun cloneGraph1MapUsingNodeAsKey(node: Node?): Node? {
    if (node == null) {
        return null
    }
    val nodeMap = mutableMapOf<Node, Node>()
    fun cloneNode(root: Node): Node {
        nodeMap[root]?.let {
            return it
        }
        val newNode = Node(root.`val`)
        nodeMap[root] = newNode

        root.neighbors.forEach { neighbor ->
            neighbor?.let {
                newNode.neighbors.add(cloneNode(it))
            }
        }
        return newNode
    }
    return cloneNode(node)
}

private class Node(var `val`: Int) {
    var neighbors = ArrayList<Node?>()
}

private fun main() {

}
