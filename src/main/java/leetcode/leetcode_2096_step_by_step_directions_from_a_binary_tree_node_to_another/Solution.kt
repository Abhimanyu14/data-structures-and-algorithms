package leetcode.leetcode_2096_step_by_step_directions_from_a_binary_tree_node_to_another

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/?envType=daily-question&envId=2024-07-16
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
private fun getDirections(root: TreeNode, startValue: Int, destValue: Int): String {
    val startPath = StringBuilder()
    val destPath = StringBuilder()

    fun findPath(node: TreeNode?, target: Int, path: StringBuilder): Boolean {
        if (node == null) {
            return false
        }

        if (node.`val` === target) {
            return true
        }

        // Try left subtree
        path.append("L")
        if (findPath(node.left, target, path)) {
            return true
        }
        path.deleteCharAt(path.length - 1) // Remove last character

        // Try right subtree
        path.append("R")
        if (findPath(node.right, target, path)) {
            return true
        }
        path.deleteCharAt(path.length - 1) // Remove last character

        return false
    }

    // Find paths from root to start and destination nodes
    findPath(root, startValue, startPath)
    findPath(root, destValue, destPath)

    val directions = StringBuilder()
    var commonPathLength = 0

    // Find the length of the common path
    while (commonPathLength < startPath.length && commonPathLength < destPath.length && startPath[commonPathLength] == destPath[commonPathLength]
    ) {
        commonPathLength++
    }

    // Add "U" for each step to go up from start to common ancestor
    for (i in 0..<startPath.length - commonPathLength) {
        directions.append("U")
    }

    // Add directions from common ancestor to destination
    for (i in commonPathLength..<destPath.length) {
        directions.append(destPath[i])
    }

    return directions.toString()
}

private fun main() {

}
