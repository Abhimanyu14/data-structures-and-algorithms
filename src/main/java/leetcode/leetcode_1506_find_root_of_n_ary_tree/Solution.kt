package leetcode.leetcode_1506_find_root_of_n_ary_tree

import data_structures.Node

/**
 * leetcode - https://leetcode.com/problems/find-root-of-n-ary-tree/
 *
 * Using bitwise operator
 * Using solution of leetcode 135(https://leetcode.com/problems/single-number/)
 *
 * Stats
 * Runtime: 6465 ms, faster than 92.31%
 * Memory Usage: 44 MB, less than 100.00%
 */
private fun findRoot(tree: List<Node>): Node? {
    val childrenValues = mutableSetOf<Int>()
    tree.forEach { node ->
        node.children.forEach { childNode ->
            childNode?.let {
                childrenValues.add(it.`val`)
            }
        }
    }
    tree.forEach {
        if (!childrenValues.contains(it.`val`)) {
            return it
        }
    }
    return null
}

/**
 * leetcode - https://leetcode.com/problems/find-root-of-n-ary-tree/
 *
 * Using set and loops
 *
 * Stats
 * Runtime: 6594 ms, faster than 84.62%
 * Memory Usage: 44.2 MB, less than 84.62%
 */
private fun findRootUsingSet(tree: List<Node>): Node? {
    val childrenValues = mutableSetOf<Int>()
    tree.forEach { node ->
        node.children.forEach { childNode ->
            childNode?.let {
                childrenValues.add(it.`val`)
            }
        }
    }
    tree.forEach {
        if (!childrenValues.contains(it.`val`)) {
            return it
        }
    }
    return null
}

private fun main() {

}
