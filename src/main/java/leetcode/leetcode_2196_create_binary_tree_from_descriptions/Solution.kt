package leetcode.leetcode_2196_create_binary_tree_from_descriptions

import data_structures.TreeNode


/**
 * leetcode - https://leetcode.com/problems/create-binary-tree-from-descriptions/?envType=daily-question&envId=2024-07-15
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
    // Maps values to TreeNode pointers
    val nodeMap: MutableMap<Int, TreeNode> = HashMap<Int, TreeNode>()

    // Stores values which are children in the descriptions
    val children: MutableSet<Int> = HashSet()

    // Iterate through descriptions to create nodes and set up tree structure
    for (description in descriptions) {
        // Extract parent value, child value, and whether it is a
        // left child (1) or right child (0)
        val parentValue = description[0]
        val childValue = description[1]
        val isLeft = description[2] == 1

        // Create parent and child nodes if not already created
        if (!nodeMap.containsKey(parentValue)) {
            nodeMap[parentValue] = TreeNode(parentValue)
        }
        if (!nodeMap.containsKey(childValue)) {
            nodeMap[childValue] = TreeNode(childValue)
        }

        // Attach child node to parent's left or right branch
        if (isLeft) {
            nodeMap[parentValue]?.left = nodeMap[childValue]
        } else {
            nodeMap[parentValue]?.right = nodeMap[childValue]
        }

        // Mark child as a child in the set
        children.add(childValue)
    }

    // Find and return the root node
    for (node in nodeMap.values) {
        if (!children.contains(node.`val`)) {
            return node // Root node found
        }
    }

    return null // Should not occur according to problem statement
}

private fun main() {

}
