package leetcode.leetcode_513_find_bottom_left_tree_value

import data_structures_and_algorithms.TreeNode
import java.util.ArrayDeque

/**
 * leetcode - https://leetcode.com/problems/find-bottom-left-tree-value/?envType=daily-question&envId=2024-02-28
 *
 * Using Queue
 *
 * Stats
 * Runtime: 199 ms, faster than 50.00%
 * Memory Usage: 37.7 MB, less than 44.44%
 */
private fun findBottomLeftValue(root: TreeNode?): Int {
    if (root == null) {
        return -1
    }
    var result = root.`val`
    var processedHeight = -1
    val queue = ArrayDeque<Pair<TreeNode, Int>>()
    queue.addLast(Pair(root, 0))
    while (queue.isNotEmpty()) {
        val temp = queue.removeFirst()
        if (temp.second > processedHeight) {
            processedHeight = temp.second
            result = temp.first.`val`
        }
        temp.first.left?.let {
            queue.addLast(Pair(it, temp.second + 1))
        }
        temp.first.right?.let {
            queue.addLast(Pair(it, temp.second + 1))
        }
    }
    return result
}

private fun main() {

}
