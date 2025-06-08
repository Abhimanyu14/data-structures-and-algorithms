package leetcode.leetcode_1485_clone_binary_tree_with_random_pointer

/**
 * leetcode - https://leetcode.com/problems/clone-binary-tree-with-random-pointer/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 * Premium Question
 *
 * Data Structure - Tree
 * Algorithm - DFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Meta
 */
private class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var random: Node? = null
}

private class NodeCopy(var `val`: Int) {
    var left: NodeCopy? = null
    var right: NodeCopy? = null
    var random: NodeCopy? = null
}

private fun copyRandomBinaryTree(root: Node?): NodeCopy? {
    if (root == null) {
        return null
    }
    val map = mutableMapOf<Node, NodeCopy>()
    val newRoot = NodeCopy(root.`val`)
    map[root] = newRoot
    fun dfs(original: Node, copy: NodeCopy) {
        original.left?.let { originalLeft ->
            if (map[originalLeft] == null) {
                map[originalLeft] = NodeCopy(originalLeft.`val`)
            }
            copy.left = map[originalLeft]
            dfs(originalLeft, copy.left!!)
        }
        original.right?.let { originalRight ->
            if (map[originalRight] == null) {
                map[originalRight] = NodeCopy(originalRight.`val`)
            }
            copy.right = map[originalRight]
            dfs(originalRight, copy.right!!)
        }
        original.random?.let { originalRandom ->
            if (map[originalRandom] == null) {
                map[originalRandom] = NodeCopy(originalRandom.`val`)
            }
            copy.random = map[originalRandom]
        }
    }

    dfs(root, newRoot)
    return newRoot
}

private fun copyRandomBinaryTree1(root: Node?): NodeCopy? {
    if (root == null) {
        return null
    }
    val map = mutableMapOf<Node, NodeCopy>()
    val newRoot = NodeCopy(root.`val`)
    map[root] = newRoot

    fun dfs1(p1: Node, p2: NodeCopy) {
        if (p1.left != null && map[p1.left] == null) {
            map[p1.left!!] = NodeCopy(p1.left!!.`val`)
        }
        if (p1.right != null && map[p1.right] == null) {
            map[p1.right!!] = NodeCopy(p1.right!!.`val`)
        }
        p2.left = map[p1.left]!!
        p2.right = map[p1.right]!!
        if (p1.left != null) {
            dfs1(p1.left!!, p2.left!!)
        }
        if (p1.right != null) {
            dfs1(p1.right!!, p2.right!!)
        }
    }

    fun dfs2(p1: Node, p2: NodeCopy) {
        p2.random = map[p1.random]!!
        if (p1.left != null) {
            dfs1(p1.left!!, p2.left!!)
        }
        if (p1.right != null) {
            dfs1(p1.right!!, p2.right!!)
        }
    }

    dfs1(root, newRoot)
    dfs2(root, newRoot)
    return newRoot
}

private fun main() {

}
