package leetcode.leetcode_200_to_299.leetcode_235_lowest_common_ancestor_of_a_binary_search_tree

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Using tree traversal
 *
 * Stats
 * Runtime: 227 ms, faster than 73.97%
 * Memory Usage: 41 MB, less than 10.74%
 */
private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || p == null || q == null || root.`val` == p.`val` || root.`val` == q.`val`) {
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
