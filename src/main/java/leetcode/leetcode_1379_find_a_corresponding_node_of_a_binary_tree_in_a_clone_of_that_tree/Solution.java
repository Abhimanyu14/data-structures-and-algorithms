package leetcode.leetcode_1379_find_a_corresponding_node_of_a_binary_tree_in_a_clone_of_that_tree;

/*
 * leetcode - https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/description/
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 5 ms, faster than 17.95%
 * Memory Usage: 51.1 MB, less than 5.05%
 *
 * Time -
 * Space -
 */

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String findRoute(TreeNode current, String pathSoFar, TreeNode target) {
        if (current.val == target.val) {
            return pathSoFar;
        }
        if (current.left != null) {
            String leftPath = findRoute(current.left, pathSoFar + "L", target);
            if (leftPath != "") {
                return leftPath;
            }
        }
        if (current.right != null) {
            String rightPath = findRoute(current.right, pathSoFar + "R", target);
            if (rightPath != "") {
                return rightPath;
            }
        }
        return "";
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode result = cloned;
        String route = findRoute(original, "", target);
        for (int i = 0; i < route.length(); i++) {
            char c = route.charAt(i);
            if (c == 'L') {
                result = result.left;
            } else {
                result = result.right;
            }
        }
        return result;
    }
}
