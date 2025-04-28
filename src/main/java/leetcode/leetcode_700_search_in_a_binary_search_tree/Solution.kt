package leetcode.leetcode_700_search_in_a_binary_search_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 * Runtime: 225 ms, faster than 91.01%
 * Memory Usage: 38 MB, less than 64.55%
 */
private fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null) {
        return root
    }
    var current = root
    while (current?.`val` != `val`) {
        if (current == null) {
            return null
        } else if (current.`val` < `val`) {
            current = current.right
        } else {
            current = current.left
        }
    }
    return current
}

private fun main() {

}
