package leetcode.leetcode_116_populating_next_right_pointers_in_each_node

/**
 * leetcode - https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 *
 * Data Structure - Tree, [ArrayDeque] (Queue)
 * Algorithm - BFS
 *
 * ArrayDeque methods - [ArrayDeque.addLast], [ArrayDeque.removeFirst], [ArrayDeque.isNotEmpty]
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
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
        val size = queue.size
        var prev: Node? = null
        var current: Node
        repeat(size) {
            current = queue.removeFirst()
            current.left?.let {
                queue.addLast(it)
            }
            current.right?.let {
                queue.addLast(it)
            }
            prev?.next = current
            prev = current
        }
    }
    return root
}

private fun main() {

}
