package leetcode.leetcode_270_closest_binary_search_tree_value

import data_structures.TreeNode
import kotlin.math.abs
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/closest-binary-search-tree-value/
 * Premium Question
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Tree
 * Algorithm - DFS
 *
 * Source - https://leetcode.com/problems/closest-binary-search-tree-value/editorial/
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(H)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun closestValue(root: TreeNode?, target: Double): Int {
    if (root == null) {
        return -1
    }
    var result = root.`val`
    var current: TreeNode? = root
    while (current != null) {
        if (abs(target - current.`val`) < abs(target - result)) {
            result = current.`val`
        } else if (abs(target - current.`val`) == abs(target - result)) {
            result = min(result, current.`val`)
        }
        current = if (current.`val` > target) {
            current.left
        } else if (current.`val` < target) {
            current.right
        } else {
            break
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/closest-binary-search-tree-value/
 * Premium Question
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Tree
 * Algorithm - DFS
 *
 * Source - https://leetcode.com/problems/closest-binary-search-tree-value/editorial/
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(H)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun closestValueUsingOptimizedDfs(root: TreeNode?, target: Double): Int {
    if (root == null) {
        return -1
    }
    var result = root.`val`
    fun dfs(current: TreeNode) {
        if (abs(target - current.`val`) < abs(target - result)) {
            result = current.`val`
        } else if (abs(target - current.`val`) == abs(target - result)) {
            result = min(result, current.`val`)
        }
        if (current.`val` > target) {
            current.left?.let {
                dfs(it)
            }
        } else if (current.`val` < target) {
            current.right?.let {
                dfs(it)
            }
        }
    }
    dfs(root)
    return result
}

/**
 * leetcode - https://leetcode.com/problems/closest-binary-search-tree-value/
 * Premium Question
 *
 * Data Structure - Tree
 * Algorithm - DFS
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Google, Meta, Microsoft
 */
private fun closestValueUsingDfs(root: TreeNode?, target: Double): Int {
    if (root == null) {
        return -1
    }
    var result = root.`val`
    fun dfs(current: TreeNode) {
        if (abs(target - current.`val`) < abs(target - result)) {
            result = current.`val`
        } else if (abs(target - current.`val`) == abs(target - result)) {
            result = min(result, current.`val`)
        }
        current.left?.let {
            dfs(it)
        }
        current.right?.let {
            dfs(it)
        }
    }
    dfs(root)
    return result
}

private fun main() {

}
