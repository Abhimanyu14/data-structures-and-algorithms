package leetcode.leetcode_108_convert_sorted_array_to_binary_search_tree

import data_structures_and_algorithms.TreeNode

/**
 * leetcode - https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Data Structure - Tree
 * Algorithm - DFS
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(log(N))
 */
private fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.isEmpty()) {
        return null
    }
    fun createBST(start: Int, end: Int): TreeNode {
        val mid = start + ((end - start) / 2)
        val root = TreeNode(nums[mid])
        if (start >= 0 && start <= mid - 1) {
            root.left = createBST(start, mid - 1)
        }
        if (mid + 1 <= end && end <= nums.lastIndex) {
            root.right = createBST(mid + 1, end)
        }
        return root
    }
    return createBST(0, nums.lastIndex)
}

private fun main() {

}
