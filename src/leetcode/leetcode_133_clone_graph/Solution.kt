package leetcode.leetcode_133_clone_graph

/**
 * leetcode - https://leetcode.com/problems/clone-graph/
 *
 * Using DFS
 *
 * Stats
 * Runtime: 218 ms, faster than 18.18%
 * Memory Usage: 37.3 MB, less than 80.52%
 */
private class Node(var `val`: Int) {
    var neighbors = ArrayList<Node?>()
}

private fun cloneGraph(node: Node?): Node? {
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

private fun main() {

}
