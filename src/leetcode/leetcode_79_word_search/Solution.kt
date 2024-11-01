package leetcode.leetcode_79_word_search

/**
 * leetcode - https://leetcode.com/problems/word-search/
 *
 * Using DFS
 *
 * Stats
 * Runtime: 3412 ms, faster than 5.06%
 * Memory Usage: 49 MB, less than 15.95%
 */
private data class Point(
    val x: Int,
    val y: Int,
)

private fun exist(board: Array<CharArray>, word: String): Boolean {
    fun getValidMoves(point: Point): List<Point> {
        return buildList {
            if (point.x - 1 >= 0) {
                add(Point(point.x - 1, point.y))
            }
            if (point.y - 1 >= 0) {
                add(Point(point.x, point.y - 1))
            }
            if (point.x + 1 < board.size) {
                add(Point(point.x + 1, point.y))
            }
            if (point.y +  1 < board[0].size) {
                add(Point(point.x, point.y + 1))
            }
        }
    }

    fun searchWord(visited: Set<Point>, point: Point, index: Int): Boolean {
        if (board[point.x][point.y] != word[index]) {
            return false
        }
        return if (index == word.lastIndex) {
            true
        } else {
            var result = false
            getValidMoves(point).forEach {
                if (!visited.contains(it)) {
                    result = result || searchWord(visited + point, it, index + 1)
                }
            }
            result
        }
    }

    board.forEachIndexed { x, row ->
        row.forEachIndexed { y, _ ->
            if (searchWord(setOf(), Point(x, y), 0)) {
                return true
            }
        }
    }
    return false
}

private fun main() {

}
