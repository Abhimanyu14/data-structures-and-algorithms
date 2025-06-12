package leetcode.leetcode_1650_lowest_common_ancestor_of_a_binary_tree_iii

/**
 * leetcode - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 * Premium Question
 *
 * Data Structure - Tree
 * Algorithm - Tree traversal
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
    if (p == null || q == null) {
        return null
    }
    val pAncestors = mutableSetOf<Node>()
    var current: Node? = p
    while (current != null) {
        pAncestors.add(current)
        current = current.parent
    }
    current = q
    while (!pAncestors.contains(current)) {
        current = current?.parent
    }
    return current
}

/**
 * leetcode - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 * Premium Question
 *
 * Data Structure - Tree
 * Algorithm - Tree traversal
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N ^ 2)
 * Space - O(N)
 *
 * Companies - Meta
 */
private class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var parent: Node? = null
}


private fun lowestCommonAncestorUsingRecursion(p: Node?, q: Node?): Node? {
    if (p == null || q == null) {
        return null
    }
    fun isADescendant(a: Node, b: Node): Boolean { // Is node A descendant of node B
        if (a == b) {
            return true
        }
        val left = b.left?.let {
            isADescendant(a, it)
        } ?: false
        val right = b.right?.let {
            isADescendant(a, it)
        } ?: false
        return left || right
    }
    if (isADescendant(p, q)) {
        return q
    }
    if (isADescendant(q, p)) {
        return p
    }
    var current = p
    var parent = current.parent
    while (parent != null) {
        if (parent.left == current) {
            parent.right?.let {
                if (isADescendant(q, it)) {
                    return parent
                }
            }
        } else {
            parent.left?.let {
                if (isADescendant(q, it)) {
                    return parent
                }
            }
        }
        current = parent
        parent = current.parent
    }
    return null
}

private fun lowestCommonAncestorUsingSetIntersection(p: Node?, q: Node?): Node? {
    var currentP = p ?: return null
    var currentQ = q ?: return null
    val pAncestors = mutableSetOf<Node>()
    val qAncestors = mutableSetOf<Node>()
    pAncestors.add(currentP)
    qAncestors.add(currentQ)
    while ((pAncestors intersect qAncestors).isEmpty()) {
        currentP.parent?.let {
            currentP = it
            pAncestors.add(it)
        }
        currentQ.parent?.let {
            currentQ = it
            qAncestors.add(it)
        }
    }
    return (pAncestors intersect qAncestors).first()
}

private fun main() {

}
