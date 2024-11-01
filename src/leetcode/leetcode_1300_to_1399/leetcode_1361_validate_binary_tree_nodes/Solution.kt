package leetcode.leetcode_1300_to_1399.leetcode_1361_validate_binary_tree_nodes

/**
 * leetcode - https://leetcode.com/problems/validate-binary-tree-nodes/
 *
 * TODO(Abhi) - To revisit
 *
 * Using DFS and Map
 *
 * Stats
 * Runtime: 301 ms, faster than 100.00%
 * Memory Usage: 41.4 MB, less than 100.00%
 */
private fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
    val parentMap = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        parentMap[i] = -1
    }
    for (i in 0 until n) {
        if (leftChild[i] != -1) {
            if (parentMap[leftChild[i]] == -1) {
                parentMap[leftChild[i]] = i
            } else {
                return false
            }
        }
        if (rightChild[i] != -1) {
            if (parentMap[rightChild[i]] == -1) {
                parentMap[rightChild[i]] = i
            } else {
                return false
            }
        }
    }
    var root = -1
    for (i in 0 until n) {
        if (parentMap[i] == -1) {
            root = i
            break
        }
    }
    if (root == -1) {
        return false
    }
    val visited = mutableSetOf<Int>()
    fun dfs(head: Int): Boolean {
        if (head == -1) {
            return true
        }
        if (visited.contains(head)) {
            return false
        }
        visited.add(head)
        return dfs(leftChild[head]) && dfs(rightChild[head])
    }

    return dfs(root) && visited.size == n
}

private fun main() {

}
