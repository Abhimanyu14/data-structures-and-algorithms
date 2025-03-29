package leetcode.leetcode_1650_lowest_common_ancestor_of_a_binary_tree_iii

/**
 * leetcode - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * Data Structure - Tree
 * Algorithm - Tree traversal
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
private class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var parent: Node? = null
}

private fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
    if (p == null || q == null) {
        return null
    }
    if (isAnDescendant(p, q)) {
        return q
    }
    if (isAnDescendant(q, p)) {
        return p
    }
    var current = p
    var parent = current.parent
    while (parent != null) {
        if (parent.left == current) {
            parent.right?.let {
                if (isAnDescendant(q, it)) {
                    return parent
                }
            }
        } else {
            parent.left?.let {
                if (isAnDescendant(q, it)) {
                    return parent
                }
            }
        }
        current = parent
        parent = current.parent
    }
    return null
}

private fun isAnDescendant(a: Node, b: Node): Boolean { // Is node A an descendant of node B
    if (a == b) {
        return true
    }
    val left = b.left?.let {
        isAnDescendant(a, it)
    } ?: false
    val right = b.right?.let {
        isAnDescendant(a, it)
    } ?: false
    return left || right
}

private fun main() {

}
