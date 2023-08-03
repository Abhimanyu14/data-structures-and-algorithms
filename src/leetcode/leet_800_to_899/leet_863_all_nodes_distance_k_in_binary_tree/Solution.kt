package leetcode.leet_800_to_899.leet_863_all_nodes_distance_k_in_binary_tree

import data_structures.TreeNode

/**
 * leetcode - https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 *
 * Using equivalent graph
 *
 * Stats
 * Runtime: 186 ms, faster than 46.67%
 * Memory Usage: 36.2 MB, less than 66.67%
 */
private fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
    if (root == null) {
        return emptyList()
    }
    val graph: MutableMap<Int, MutableList<Int>> = HashMap()
    val visited: MutableSet<Int> = HashSet()
    val result: MutableList<Int> = ArrayList()

    fun buildGraph(cur: TreeNode, parent: TreeNode?) {
        if (parent != null) {
            graph.computeIfAbsent(
                cur.`val`
            ) {
                ArrayList()
            }.add(parent.`val`)
            graph.computeIfAbsent(
                parent.`val`
            ) {
                ArrayList()
            }.add(cur.`val`)
        }
        cur.left?.let {
            buildGraph(it, cur)
        }
        cur.right?.let {
            buildGraph(it, cur)
        }
    }

    fun dfs(cur: Int, distance: Int, k: Int) {
        if (distance == k) {
            result.add(cur)
            return
        }
        for (neighbor in graph.getOrDefault(cur, ArrayList())) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor)
                dfs(neighbor, distance + 1, k)
            }
        }
    }

    buildGraph(root, null)
    target?.`val`?.let {
        visited.add(it)
        dfs(it, 0, k)
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 *
 * Using path string and DFS
 *
 * Stats
 * Runtime: 198 ms, faster than 13.33%
 * Memory Usage: 37.2 MB, less than 33.33%
 */
fun distanceKUsingStringPath(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
    if (root?.`val` == target?.`val`) {
        root?.let {
            return childrenAtK(it, k)
        }
    }

    val path = findTargetPath(root, target, "")
    println("Path $path")
    if (path.isEmpty()) {
        return emptyList()
    }

    val result = mutableListOf<Int>()
    var node = root
    var tempDist: Int
    path.forEachIndexed { index, c ->
        tempDist = k - (path.length - index)
        if (tempDist == 0) {
            node?.`val`?.let {
                result.add(it)
            }
        } else if (tempDist > 0) {
            if (c == 'L') {
                node?.right?.let {
                    result.addAll(childrenAtK(it, tempDist - 1))
                }
            } else if (c == 'R') {
                node?.left?.let {
                    result.addAll(childrenAtK(it, tempDist - 1))
                }
            }
        }

        if (c == 'L') {
            node = node?.left
        } else if (c == 'R') {
            node = node?.right
        }
    }
    node?.let {
        result.addAll(childrenAtK(it, k))
    }
    return result
}

fun childrenAtK(root: TreeNode, k: Int): List<Int> {
    if (k == 0) {
        return listOf(root.`val`)
    }
    val result = mutableListOf<Int>()
    root.left?.let {
        result.addAll(childrenAtK(it, k - 1))
    }
    root.right?.let {
        result.addAll(childrenAtK(it, k - 1))
    }
    return result
}

fun findTargetPath(root: TreeNode?, target: TreeNode?, path: String): String {
    if (root != null && target != null && root.`val` == target.`val`) {
        return path
    }
    if (root?.left != null) {
        val leftPath = findTargetPath(root.left, target, "${path}L")
        if (leftPath != "") {
            return leftPath
        }
    }
    if (root?.right != null) {
        return findTargetPath(root.right, target, "${path}R")
    }
    return ""
}

private fun main() {

}
