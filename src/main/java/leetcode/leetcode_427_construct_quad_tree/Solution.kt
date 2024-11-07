package leetcode.leetcode_427_construct_quad_tree

/**
 * leetcode - https://leetcode.com/problems/construct-quad-tree/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 180 ms, faster than 95.83%
 * Memory Usage: 37.5 MB, less than 66.67%
 */
class Node(
    var `val`: Boolean,
    var isLeaf: Boolean,
) {
    var topLeft: Node? = null
    var topRight: Node? = null
    var bottomLeft: Node? = null
    var bottomRight: Node? = null
}

private fun construct(grid: Array<IntArray>): Node? {
    fun processQuad(x: Int, y: Int, size: Int): Node {
        val first = grid[x][y]
        var same = true
        var i = x
        while (same && i < (x + size)) {
            for (j in y until (y + size)) {
                if (grid[i][j] != first) {
                    same = false
                    break
                }
            }
            i++
        }
        return if (same) {
            Node(
                `val` = first == 1,
                isLeaf = true,
            )
        } else {
            Node(
                `val` = true,
                isLeaf = false,
            ).apply {
                topLeft = processQuad(x, y, (size / 2))
                topRight = processQuad(x, y + (size / 2), (size / 2))
                bottomLeft = processQuad(x + (size / 2), y, (size / 2))
                bottomRight = processQuad(x + (size / 2), y + (size / 2), (size / 2))
            }
        }
    }
    return processQuad(0, 0, grid.size)
}

private fun main() {

}
