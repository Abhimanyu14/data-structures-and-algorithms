package leetcode.leet_2600_to_2699.leet_2641_cousins_in_binary_tree_ii

import data_structures_and_algorithms.TreeNode
import java.util.LinkedList
import java.util.Queue


/**
 * leetcode - https://leetcode.com/problems/cousins-in-binary-tree-ii/?envType=daily-question&envId=2024-10-23
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun replaceValueInTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    val nodeQueue: Queue<TreeNode> = LinkedList()
    nodeQueue.offer(root)
    val levelSums: MutableList<Int> = ArrayList()

    // First BFS: Calculate sum of nodes at each level
    while (nodeQueue.isNotEmpty()) {
        var levelSum = 0
        val levelSize = nodeQueue.size
        for (i in 0..<levelSize) {
            val currentNode: TreeNode = nodeQueue.poll()
            levelSum += currentNode.`val`
            currentNode.left?.let {
                nodeQueue.offer(it)
            }
            currentNode.right?.let {
                nodeQueue.offer(it)
            }
        }
        levelSums.add(levelSum)
    }

    // Second BFS: Update each node's value to sum of its cousins
    nodeQueue.offer(root)
    var levelIndex = 1
    root.`val` = 0 // Root has no cousins
    while (nodeQueue.isNotEmpty()) {
        val levelSize = nodeQueue.size
        for (i in 0..<levelSize) {
            val currentNode: TreeNode = nodeQueue.poll()
            val siblingSum: Int = (currentNode.left?.`val` ?: 0) + (currentNode.right?.`val` ?: 0)
            currentNode.left?.let {
                it.`val` = levelSums[levelIndex] - siblingSum
                nodeQueue.offer(it)
            }
            currentNode.right?.let {
                it.`val` = levelSums[levelIndex] - siblingSum
                nodeQueue.offer(it)
            }
        }
        levelIndex++
    }
    return root
}

private fun main() {

}
