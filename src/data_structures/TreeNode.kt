package data_structures

import java.util.LinkedList
import java.util.Queue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun createBinaryTree(list: List<Int?>): TreeNode? {
    if (list.isEmpty()) {
        return null
    }
    val q: Queue<TreeNode?> = LinkedList()
    val first = list[0] ?: return null
    val root = TreeNode(first)
    q.add(root)
    var index = 1
    while (q.isNotEmpty() && index <= list.lastIndex) {
        val top = q.remove()
        if (list[index] != null) {
            top?.left = TreeNode(list[index] ?: 0)
        }
        if (index + 1 <= list.lastIndex && list[index + 1] != null) {
            top?.right = TreeNode(list[index + 1] ?: 0)
        }
        index += 2
    }
    return root
}

fun TreeNode?.height(height: Int = -1): Int {
    if (this == null) return height
    return maxOf(left.height(height + 1), right.height(height + 1))
}

fun TreeNode.isLeaf(): Boolean {
    return this.left == null && this.right == null
}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}
