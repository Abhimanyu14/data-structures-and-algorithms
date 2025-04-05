package leetcode.leetcode_536_construct_binary_tree_from_string

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/construct-binary-tree-from-string
 * Premium Question
 *
 * Data Structure - [Tree], [ArrayDeque] (Stack)
 * Algorithm -
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
private fun str2tree(s: String): TreeNode? {
    if (s.isEmpty()) {
        return null
    }
    var index = 0
    fun getNodeValue(): Int {
        var isNegative = false
        if (index < s.length && s[index] == '-') {
            isNegative = true
            index++
        }
        var value = 0
        while (index < s.length && s[index].isDigit()) {
            value = (value * 10) + s[index].digitToInt()
            index++
        }
        return if (isNegative) {
            value * -1
        } else {
            value
        }
    }
    val stack = ArrayDeque<TreeNode>()
    val root = TreeNode(getNodeValue())
    stack.addLast(root)
    var currentNode = root
    while (index <= s.lastIndex) {
        if (s[index] == '(') {
            index++
            val newNode = TreeNode(getNodeValue())
            if (currentNode.left == null) {
                currentNode.left = newNode
            } else {
                currentNode.right = newNode
            }
            currentNode = newNode
            stack.addLast(currentNode)
        } else {
            stack.removeLast()
            if (stack.isNotEmpty()) {
                currentNode = stack.last()
            }
            index++
        }
    }
    return root
}

private fun main() {

}
