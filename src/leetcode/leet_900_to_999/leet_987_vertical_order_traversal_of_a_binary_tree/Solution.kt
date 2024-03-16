package leetcode.leet_900_to_999.leet_987_vertical_order_traversal_of_a_binary_tree

import data_structures_and_algorithms.TreeNode
import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 *
 * Using recursion, DFS, map and custom comparator
 *
 * Stats
 * Runtime: 201 ms, faster than 53.23%
 * Memory Usage: 39 MB, less than 12.90%
 */
private fun verticalTraversal(root: TreeNode?): List<List<Int>> {
    if (root == null) {
        return emptyList()
    }
    var minCol = 0
    var maxCol = 0
    val map = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

    fun parseTree(head: TreeNode, row: Int, col: Int) {
        map.computeIfAbsent(col) {
            mutableListOf()
        }.add(Pair(row, head.`val`))
        head.left?.let {
            minCol = min(minCol, col - 1)
            parseTree(it, row + 1, col - 1)
        }
        head.right?.let {
            maxCol = max(maxCol, col + 1)
            parseTree(it, row + 1, col + 1)
        }
    }
    parseTree(root, 0, 0)

    val result = mutableListOf<List<Int>>()
    for (i in minCol..maxCol) {
        result.add(
            map.getOrDefault(i, emptyList())
                .sortedWith { p1, p2 ->
                    if (p1.first == p2.first) {
                        p1.second - p2.second
                    } else {
                        p1.first - p2.first
                    }
                }.map {
                    it.second
                }
        )
    }
    return result
}

private fun main() {

}
