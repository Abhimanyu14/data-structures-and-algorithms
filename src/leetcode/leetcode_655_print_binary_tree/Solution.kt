package leetcode.leetcode_655_print_binary_tree

import data_structures_and_algorithms.TreeNode
import data_structures_and_algorithms.height
import kotlin.math.pow

/**
 * Stats
 * Runtime: 232 ms, faster than 100.00%
 * Memory Usage: 37.6 MB, less than 36.36%
 */
private fun printTree(root: TreeNode?): List<List<String>> {
    val height = root.height()
    val rows = height + 1
    val columns = 2.0.pow(height + 1).toInt() - 1
    val result: MutableList<MutableList<String>> = MutableList(rows) {
        MutableList(columns) {
            ""
        }
    }
    fillData(root, height, 0, (columns - 1) / 2, result)
    return result
}

private fun fillData(root: TreeNode?, height: Int, i: Int, j: Int, result: MutableList<MutableList<String>>) {
    if (root == null) return
    result[i][j] = root.`val`.toString()
    fillData(root.left, height, i + 1, j - (2.0.pow(height - i - 1)).toInt(), result)
    fillData(root.right, height, i + 1, j + (2.0.pow(height - i - 1)).toInt(), result)
}

private fun main() {
    val s1 = TreeNode(1)
    val s2 = TreeNode(2)
    s1.left = s2

    val t1 = TreeNode(1)
    val t2 = TreeNode(2)
    val t3 = TreeNode(3)
    val t4 = TreeNode(4)

    t1.left = t2
    t1.right = t3

    t2.right = t4

    val u1 = TreeNode(1)
    val u2 = TreeNode(2)
    val u3 = TreeNode(3)
    val u4 = TreeNode(4)
    val u5 = TreeNode(5)

    u1.left = u2
    u1.right = u5

    u2.left = u3
    u3.left = u4

    println(printTree(s1).toString())
    println(printTree(t1).toString())
    println(printTree(u1).toString())
}
