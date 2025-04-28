package leetcode.leetcode_536_construct_binary_tree_from_string

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/construct-binary-tree-from-string
 * Premium Question
 *
 * Data Structure - [Tree], [ArrayDeque] (Stack)
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
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

/**
 * leetcode - https://leetcode.com/problems/construct-binary-tree-from-string
 * Premium Question
 *
 * Data Structure - Stack
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N) - Implicit stack
 *
 * Companies - Meta
 */
private fun str2treeUsingRecursion(s: String): TreeNode? {
    if (s.isEmpty()) {
        return null
    }
    fun construct(index: Int): Pair<TreeNode, Int> {
        var sign = 1
        var rootValue = 0
        var pointer = index
        if (s[pointer] == '-') {
            sign = -1
            pointer++
        }
        while (pointer <= s.lastIndex && s[pointer].isDigit()) {
            rootValue = (rootValue * 10) + s[pointer].digitToInt()
            pointer++
        }
        val root = TreeNode(sign * rootValue)
        if (pointer <= s.lastIndex && s[pointer] == '(') {
            val leftTree = construct(pointer + 1)
            root.left = leftTree.first
            pointer = leftTree.second
        }
        if (pointer <= s.lastIndex && s[pointer] == '(') {
            val rightTree = construct(pointer + 1)
            root.right = rightTree.first
            pointer = rightTree.second
        }
        return Pair(root, pointer + 1)
    }
    return construct(0).first
}

private fun main() {

}
