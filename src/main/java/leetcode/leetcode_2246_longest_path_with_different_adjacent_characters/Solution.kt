package leetcode.leetcode_2246_longest_path_with_different_adjacent_characters

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
 *
 * Using DFS
 *
 * Stats
 * Runtime: 1346 ms, faster than 75.00%
 * Memory Usage: 163.9 MB, less than 25.00%
 */
private fun longestPath(parent: IntArray, s: String): Int {
    val children: MutableMap<Int, MutableList<Int>> = mutableMapOf()
    for (i in 1..<parent.size) {
        children.computeIfAbsent(parent[i]) { _: Int -> mutableListOf() }.add(i)
    }

    var longestPath = 1
    fun dfs(currentNode: Int): Int {
        if (!children.containsKey(currentNode)) {
            return 1
        }

        var longestChain = 0
        var secondLongestChain = 0
        children[currentNode]?.forEach { child ->
            val longestChainStartingFromChild = dfs(child)
            if (s[currentNode] != s[child]) {
                if (longestChainStartingFromChild > longestChain) {
                    secondLongestChain = longestChain
                    longestChain = longestChainStartingFromChild
                } else if (longestChainStartingFromChild > secondLongestChain) {
                    secondLongestChain = longestChainStartingFromChild
                }
            }
        }

        longestPath = max(longestPath, longestChain + secondLongestChain + 1)
        return longestChain + 1
    }
    dfs(0)
    return longestPath
}

/*
// With comments
private fun longestPath(parent: IntArray, s: String): Int {
    val n = parent.size
    val children: MutableMap<Int?, MutableList<Int>> = mutableMapOf()
    // Start from node 1, since root node 0 does not have a parent.
    for (i in 1 until n) {
        children.computeIfAbsent(parent[i]) { _: Int? -> mutableListOf() }.add(i)
    }

    var longestPath = 1
    fun dfs(currentNode: Int, children: Map<Int?, MutableList<Int>>, s: String): Int {
        // If the node is the only child, return 1 for the currentNode itself.
        if (!children.containsKey(currentNode)) {
            return 1
        }

        // Longest and second-longest path starting from currentNode (does not count the
        // currentNode itself).
        var longestChain = 0
        var secondLongestChain = 0
        children[currentNode]?.forEach { child ->
            // Get the number of nodes in the longest chain starting from the child,
            // including the child.
            val longestChainStartingFromChild = dfs(child, children, s)
            // We won't move to the child if it has the same character as the currentNode.
            if (s[currentNode] != s[child]) {
                // Modify the longestChain and secondLongestChain if longestChainStartingFromChild
                // is bigger.
                if (longestChainStartingFromChild > longestChain) {
                    secondLongestChain = longestChain
                    longestChain = longestChainStartingFromChild
                } else if (longestChainStartingFromChild > secondLongestChain) {
                    secondLongestChain = longestChainStartingFromChild
                }
            }
        }

        // Add "1" for the node itself.
        longestPath = max(longestPath, longestChain + secondLongestChain + 1)
        return longestChain + 1
    }
    dfs(0, children, s)
    return longestPath
}
*/

private fun main() {

}
