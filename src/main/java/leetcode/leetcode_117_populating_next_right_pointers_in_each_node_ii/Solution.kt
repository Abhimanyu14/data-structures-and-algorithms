package leetcode.leetcode_117_populating_next_right_pointers_in_each_node_ii

/**
 * leetcode - https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * Data Structure - [ArrayDeque]
 * Algorithm - BFS
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
        return root
    }
    val queue = ArrayDeque<Node>()
    queue.addLast(root)
    while (queue.isNotEmpty()) {
        val size = queue.size
        var prev = queue.removeFirst()
        prev.left?.let {
            queue.addLast(it)
        }
        prev.right?.let {
            queue.addLast(it)
        }
        for (i in 0..(size - 2)) {
            val current = queue.removeFirst()
            current.left?.let {
                queue.addLast(it)
            }
            current.right?.let {
                queue.addLast(it)
            }
            prev.next = current
            prev = current
        }
    }
    return root
}

private fun main() {

}
