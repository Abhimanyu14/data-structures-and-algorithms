package leetcode.leetcode_297_serialize_and_deserialize_binary_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - BFS
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private const val MY_SEPARATOR = ","
private const val NULL = "null"

private class Codec {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null) {
            return ""
        }
        val result = StringBuilder()
        val queue = ArrayDeque<TreeNode?>()
        queue.addLast(root)
        var nonNullNodeCount = 1
        while (nonNullNodeCount > 0) {
            val current = queue.removeFirst()
            if (current == null) {
                result.append(NULL)
            } else {
                nonNullNodeCount--
                result.append(current.`val`)
                queue.addLast(current.left)
                queue.addLast(current.right)
                if (current.left != null) {
                    nonNullNodeCount++
                }
                if (current.right != null) {
                    nonNullNodeCount++
                }
            }
            if (queue.isNotEmpty()) {
                result.append(MY_SEPARATOR)
            }
        }
        return result.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (`data` == "") {
            return null
        }
        val nodes = `data`.split(MY_SEPARATOR).map { it.toIntOrNull() }
        var index = 1
        val root = TreeNode(nodes.first() ?: 0)
        val queue = ArrayDeque<TreeNode?>()
        queue.addLast(root)
        while (index <= nodes.lastIndex) {
            val current = queue.removeFirst()
            nodes[index]?.let {
                current?.left = TreeNode(it)
                queue.addLast(current?.left)
            }
            index++
            if (index > nodes.lastIndex) {
                break
            }
            nodes[index]?.let {
                current?.right = TreeNode(it)
                queue.addLast(current?.right)
            }
            index++
        }
        return root
    }
}


private fun main() {

}
