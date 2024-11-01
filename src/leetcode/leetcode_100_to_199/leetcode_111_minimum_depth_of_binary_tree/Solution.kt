package leetcode.leetcode_100_to_199.leetcode_111_minimum_depth_of_binary_tree

import data_structures_and_algorithms.TreeNode
import java.util.LinkedList
import java.util.Queue
import kotlin.math.min


/**
 * leetcode - https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Using recursion, Depth first search (DFS)
 *
 * Stats
 * Runtime: 498 ms, faster than 59.54%
 * Memory Usage: 57.5 MB, less than 69.53%
 */
private fun minDepthUsingDfs(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    return if (root.left == null) {
        1 + minDepth(root.right)
    } else if (root.right == null) {
        1 + minDepth(root.left)
    } else {
        1 + min(minDepth(root.left), minDepth(root.right))
    }
}

/**
 * leetcode - https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Using recursion, Breadth first search (BFS)
 *
 * Stats
 * Runtime: 490 ms, faster than 65.65%
 * Memory Usage: 56.8 MB, less than 75.00%
 */
private fun minDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    val q: Queue<TreeNode?> = LinkedList()
    q.add(root)
    var depth = 1
    while (q.isNotEmpty()) {
        var qSize = q.size
        while (qSize > 0) {
            qSize--
            val node = q.remove() ?: continue
            if (node.left == null && node.right == null) {
                return depth
            }
            q.add(node.left)
            q.add(node.right)
        }
        depth++
    }
    return -1
}

private fun main() {

}
