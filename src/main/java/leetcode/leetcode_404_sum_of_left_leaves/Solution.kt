package leetcode.leetcode_404_sum_of_left_leaves

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/sum-of-left-leaves/?envType=daily-question&envId=2024-04-14
 *
 * Using queue
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 174 ms, faster than 11.46%
 * Memory Usage: 38 MB, less than 5.21%
 *
 * Time -
 * Space -
 */
private fun sumOfLeftLeaves(root: TreeNode?): Int {
    if (root == null || (root.left == null && root.right == null)) {
        return 0
    }
    var result = 0
    val queue = ArrayDeque<Pair<TreeNode, Boolean>>()
    root.left?.let {
        queue.addLast(Pair(it, true))
    }
    root.right?.let {
        queue.addLast(Pair(it, false))
    }
    var current: Pair<TreeNode, Boolean>
    while (queue.isNotEmpty()) {
        current = queue.removeFirst()
        if (current.second && current.first.left == null && current.first.right == null) {
            result += current.first.`val`
        }
        current.first.left?.let {
            queue.addLast(Pair(it, true))
        }
        current.first.right?.let {
            queue.addLast(Pair(it, false))
        }
    }
    return result
}

private fun main() {

}
