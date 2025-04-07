package leetcode.leetcode_529_minesweeper

/**
 * leetcode - https://leetcode.com/problems/minesweeper/description/
 *
 * Data Structure - [Set], [List], [Array]
 * Algorithm - BFS (Recursion)
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N^2)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
    val visited = mutableSetOf<String>()
    fun getValidAdjacentSquares(x: Int, y: Int): List<IntArray> {
        val result = mutableListOf<IntArray>()
        if (x > 0) {
            if (y > 0) {
                result.add(intArrayOf(x - 1, y - 1))
            }
            result.add(intArrayOf(x - 1, y))
            if (y < board[0].lastIndex) {
                result.add(intArrayOf(x - 1, y + 1))
            }
        }
        if (y > 0) {
            result.add(intArrayOf(x, y - 1))
        }
        if (y < board[0].lastIndex) {
            result.add(intArrayOf(x, y + 1))
        }
        if (x < board.lastIndex) {
            if (y > 0) {
                result.add(intArrayOf(x + 1, y - 1))
            }
            result.add(intArrayOf(x + 1, y))
            if (y < board[0].lastIndex) {
                result.add(intArrayOf(x + 1, y + 1))
            }
        }
        return result
    }

    fun handleClick(x: Int, y: Int) {
        if (visited.contains("$x,$y")) {
            return
        }
        if (board[x][y] == 'M') {
            board[x][y] = 'X'
            return
        }
        var count = 0
        getValidAdjacentSquares(x, y).forEach { (p, q) ->
            if (board[p][q] == 'M') {
                count++
            }
        }
        if (count > 0) {
            board[x][y] = '0' + count
            return
        }
        board[x][y] = 'B'
        visited.add("$x,$y")
        getValidAdjacentSquares(x, y).forEach { (p, q) ->
            handleClick(p, q)
        }
    }
    handleClick(click[0], click[1])
    return board
}

private fun main() {

}
