package leetcode.leetcode_900_to_999.leetcode_988_smallest_string_starting_from_leaf

import data_structures_and_algorithms.TreeNode
import java.util.LinkedList
import java.util.Queue


/**
 * leetcode - https://leetcode.com/problems/smallest-string-starting-from-leaf/
 *
 * TODO(Abhi) - To revisit
 *
 * Using BFS
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 180 ms, faster than 100.00%
 * Memory Usage: 37.4 MB, less than 50.00%
 *
 * Time -
 * Space -
 */
private fun smallestFromLeaf(root: TreeNode): String {
    var smallestString = ""
    val nodeQueue: Queue<Pair<TreeNode, String>> = LinkedList()

    // Add root node to queue along with its value converted to a character
    nodeQueue.add(Pair(root, ('a' + root.`val`).toString()))

    // Perform BFS traversal until queue is empty
    while (!nodeQueue.isEmpty()) {
        // Pop the leftmost node and its corresponding string from queue
        val pair: Pair<TreeNode, String> = nodeQueue.poll()
        val node: TreeNode = pair.first
        val currentString: String = pair.second

        // If current node is a leaf node
        if (node.left == null && node.right == null) {
            // Update smallest_string if it's empty or current string is smaller
            smallestString = if (smallestString.isEmpty()) {
                currentString
            } else {
                if (currentString < smallestString) {
                    currentString
                } else {
                    smallestString
                }
            }
        }

        // If current node has a left child, append it to queue
        node.left?.let {
            nodeQueue.add(Pair(it, ('a' + it.`val`).toString() + currentString))
        }

        // If current node has a right child, append it to queue
        node.right?.let {
            nodeQueue.add(Pair(it, ('a' + it.`val`).toString() + currentString))
        }
    }

    return smallestString
}

private fun main() {

}
