package leetcode.leet_1600_to_1699.leet_1609_even_odd_tree

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/even-odd-tree/?envType=daily-question&envId=2024-02-29
 *
 * Using BFS and Queue
 *
 * Stats
 * Runtime: 541 ms, faster than 50.00%
 * Memory Usage: 61.3 MB, less than 16.67%
 */
private fun isEvenOddTree(root: TreeNode?): Boolean {
    if (root == null) {
        return false
    }
    var currentLevel = -1
    var currentItem = 0
    val queue = ArrayDeque<Pair<TreeNode, Int>>()
    queue.addLast(Pair(root, 0))
    while (queue.isNotEmpty()) {
        val temp = queue.removeFirst()
        if (temp.second % 2 == 0) {
            if (temp.first.`val` % 2 == 0) {
                return false
            }
            if (temp.second > currentLevel) {
                currentLevel = temp.second
            } else {
                if (temp.first.`val` <= currentItem) {
                    return false
                }
            }
            currentItem = temp.first.`val`
        } else {
            if (temp.first.`val` % 2 != 0) {
                return false
            }
            if (temp.second > currentLevel) {
                currentLevel = temp.second
            } else {
                if (temp.first.`val` >= currentItem) {
                    return false
                }
            }
            currentItem = temp.first.`val`
        }
        temp.first.left?.let {
            queue.addLast(Pair(it, temp.second + 1))
        }
        temp.first.right?.let {
            queue.addLast(Pair(it, temp.second + 1))
        }
    }
    return true
}

private fun main() {

}
