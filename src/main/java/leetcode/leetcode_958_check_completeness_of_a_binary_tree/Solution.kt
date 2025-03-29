package leetcode.leetcode_958_check_completeness_of_a_binary_tree

/**
 * leetcode - https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 *
 * Data Structure - Tree
 * Algorithm - BFS (Tree traversal)
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private fun isCompleteTree(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }
    val queue = ArrayDeque<TreeNode>()
    var isEndFound = false
    queue.add(root)
    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        if (current.left == null) {
            isEndFound = true
        } else {
            if (isEndFound) {
                return false
            }
            queue.addLast(current.left!!)
        }
        if (current.right == null) {
            isEndFound = true
        } else {
            if (isEndFound) {
                return false
            }
            queue.addLast(current.right!!)
        }
    }
    return true
}

private fun main() {

}
