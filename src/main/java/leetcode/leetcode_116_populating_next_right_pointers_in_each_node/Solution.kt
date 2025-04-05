package leetcode.leetcode_116_populating_next_right_pointers_in_each_node

/**
 * leetcode - https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 *
 * Data Structure - [Tree], [ArrayDeque] (Queue)
 * Algorithm - BFS
 *
 * ArrayDeque methods - [ArrayDeque.addLast], [ArrayDeque.removeFirst], [ArrayDeque.isNotEmpty]
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

private fun connect(root: Node?): Node? {
    if (root == null) {
        return null
    }
    val queue = ArrayDeque<Node>()
    queue.addLast(root)
    while (queue.isNotEmpty()) {
        val nodesInLevel = queue.size
        var previousNode = queue.removeFirst()
        previousNode.left?.let {
            queue.addLast(it)
        }
        previousNode.right?.let {
            queue.addLast(it)
        }
        for (i in 1..<nodesInLevel) {
            val currentNode = queue.removeFirst()
            currentNode.left?.let {
                queue.addLast(it)
            }
            currentNode.right?.let {
                queue.addLast(it)
            }
            previousNode.next = currentNode
            previousNode = currentNode
        }
    }
    return root
}

private fun main() {

}
