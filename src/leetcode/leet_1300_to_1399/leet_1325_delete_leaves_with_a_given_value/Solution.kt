package leetcode.leet_1300_to_1399.leet_1325_delete_leaves_with_a_given_value

import data_structures_and_algorithms.TreeNode
import data_structures_and_algorithms.isLeaf

/**
 * Stats
 * Runtime: 209 ms, faster than 91.67%
 * Memory Usage: 35.3 MB, less than 100.00%
 */
private fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
    if (root == null) return null
    removeIfTargetLeaf(root, true, root.left, target)
    removeIfTargetLeaf(root, false, root.right, target)
    if (shouldBeRemoved(root, target)) {
        return null
    }
    return root
}

private fun removeIfTargetLeaf(parent: TreeNode, leftChild: Boolean, root: TreeNode?, target: Int) {
    if (root == null) return
    removeIfTargetLeaf(root, true, root.left, target)
    removeIfTargetLeaf(root, false, root.right, target)
    if (shouldBeRemoved(root, target)) {
        if (leftChild) {
            parent.left = null
        } else {
            parent.right = null
        }
    }
}

private fun shouldBeRemoved(root: TreeNode, target: Int): Boolean {
    return root.isLeaf() && root.`val` == target
}

private fun main() {
    val p1 = TreeNode(1)
    val p2 = TreeNode(2)
    val p3 = TreeNode(3)
    val p4 = TreeNode(2)
    val p5 = TreeNode(2)
    val p6 = TreeNode(4)
    p1.left = p2
    p1.right = p3

    p2.left = p4

    p3.left = p5
    p3.right = p6

    val q1 = TreeNode(1)
    val q2 = TreeNode(3)
    val q3 = TreeNode(3)
    val q4 = TreeNode(3)
    val q5 = TreeNode(2)
    q1.left = q2
    q1.right = q3

    q2.left = q4
    q2.right = q5

    val r1 = TreeNode(1)
    val r2 = TreeNode(2)
    val r3 = TreeNode(2)
    val r4 = TreeNode(2)

    r1.left = r2
    r2.left = r3
    r3.left = r4

    val s1 = TreeNode(1)
    val s2 = TreeNode(1)
    val s3 = TreeNode(1)

    s1.left = s2
    s1.left = s3

    println(removeLeafNodes(p1, 2).toString())
    println(removeLeafNodes(q1, 3).toString())
    println(removeLeafNodes(r1, 2).toString())
    println(removeLeafNodes(s1, 1).toString())
}
