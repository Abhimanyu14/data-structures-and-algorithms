package leetcode.leet_1100_to_1199.leet_1110_delete_nodes_and_return_forest

import data_structures.TreeNode
import data_structures.createBinaryTree
import data_structures.printBinaryTree

/**
 * leetcode - https://leetcode.com/problems/delete-nodes-and-return-forest/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 192 ms, faster than 97.44%
 * Memory Usage: 39.4 MB, less than 25.64%
 */
private fun delNodes(root: TreeNode?, toDelete: IntArray): List<TreeNode?> {
    val result = mutableListOf<TreeNode>()

    fun processHead(head: TreeNode?) {
        if (head == null) {
            return
        }
        result.add(head)
        if (toDelete.contains(head.`val`)) {
            result.remove(head)
            head.left?.let {
                processHead(it)
            }
            head.right?.let {
                processHead(it)
            }
            return
        }
        val toProcess = ArrayDeque<TreeNode>()
        toProcess.addLast(head)

        var temp: TreeNode?
        var temp1: TreeNode?
        var temp2: TreeNode?
        while (toProcess.isNotEmpty()) {
            temp = toProcess.removeFirst()
            temp.left?.let {
                if (toDelete.contains(it.`val`)) {
                    temp1 = it.left
                    temp2 = it.right
                    temp.left = null
                    processHead(temp1)
                    processHead(temp2)
                } else {
                    toProcess.add(it)
                }
            }
            temp.right?.let {
                if (toDelete.contains(it.`val`)) {
                    temp1 = it.left
                    temp2 = it.right
                    temp.right = null
                    processHead(temp1)
                    processHead(temp2)
                } else {
                    toProcess.add(it)
                }
            }
        }
    }
    processHead(root)

    return result
}

private fun main() {
    val tree = createBinaryTree(listOf(1, 3, 2, null, 6, 4, null, null, null, 5))
    delNodes(tree, intArrayOf(2, 5, 3)).forEach {
        printBinaryTree(it)
        println()
    }
}
