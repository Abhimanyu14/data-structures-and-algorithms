package data_structures.data_structures

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun createBinaryTree(list: List<Int?>): TreeNode? {
    if (list.isEmpty()) {
        return null
    }
    val first = list[0] ?: return null
    val root = TreeNode(first)
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
