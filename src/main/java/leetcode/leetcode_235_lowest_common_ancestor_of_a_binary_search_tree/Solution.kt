package leetcode.leetcode_235_lowest_common_ancestor_of_a_binary_search_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Data Structure - Tree
 * Algorithm - Tree traversal (Recursion)
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 181 ms, faster than 88.69%
 * Memory Usage: 49.38 MB, less than 5.66%
 *
 * Time - O(log N)
 * Space - O(log N)
 *
 * Companies - Meta
 */
private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    return if (root == null || p == null || q == null) {
        null
    } else if (p.`val` < root.`val` && q.`val` < root.`val`) {
        lowestCommonAncestor(root.left, p, q)
    } else if (p.`val` > root.`val` && q.`val` > root.`val`) {
        lowestCommonAncestor(root.right, p, q)
    } else {
        root
    }
}

/**
 * leetcode - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Data Structure - Tree
 * Algorithm - Tree traversal (Iteration)
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
private fun lowestCommonAncestor1(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || p == null || q == null) {
        return root
    }
    var current = root
    while (current != null) {
        current = if (current.`val` < p.`val` || current.`val` < q.`val`) {
            current.right
        } else if (current.`val` > p.`val` || current.`val` > q.`val`) {
            current.left
        } else {
            return current
        }
    }
    return null
}

private fun main() {

}
