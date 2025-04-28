package data_structures

internal class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

internal fun createBinaryTree(list: List<Int?>): TreeNode? {
    if (list.isEmpty() || list[0] == null) {
        return null
    }

    val first = list[0] ?: return null
    val root = TreeNode(first)

    var aheadIndex = 1
    var currentNode: TreeNode

    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)

    while (queue.isNotEmpty()) {
        currentNode = queue.removeFirst()

        currentNode.left = list[aheadIndex]?.run {
            TreeNode(this)
        }
        currentNode.left?.let {
            queue.addLast(it)
        }
        aheadIndex++

        if (aheadIndex == list.size) {
            break
        }

        currentNode.right = list[aheadIndex]?.run {
            TreeNode(this)
        }
        currentNode.right?.let {
            queue.addLast(it)
        }
        aheadIndex++
    }

    return root
}

internal fun printBinaryTree(root: TreeNode?) {
    val queue = ArrayDeque<TreeNode?>()
    queue.addLast(root)
    var temp: TreeNode?
    while (queue.isNotEmpty()) {
        temp = queue.removeFirst()
        print("${temp?.`val`} ")
        if (temp != null) {
            queue.addLast(temp.left)
            queue.addLast(temp.right)
        }
    }
}

internal fun TreeNode?.height(height: Int = -1): Int {
    if (this == null) return height
    return maxOf(left.height(height + 1), right.height(height + 1))
}

internal fun TreeNode.isLeaf(): Boolean {
    return this.left == null && this.right == null
}

/**
 * Used in leetcode questions
 */
internal class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}
