package leetcode.leetcode_1931_painting_a_grid_with_three_different_colors

/**
 * leetcode - https://leetcode.com/problems/painting-a-grid-with-three-different-colors/description/?envType=daily-question&envId=2025-05-18
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Google
 */
private fun colorTheGridUsingBruteForce(m: Int, n: Int): Int {
    var result = 0
    val grid = Array(m) {
        IntArray(n)
    }

    fun getNextPost(x: Int, y: Int): Pair<Int, Int>? {
        return if (x == m - 1 && y == n - 1) {
            result = (result + 1) % 1_000_000_007
            null
        } else if (y < n - 1) {
            Pair(x, y + 1)
        } else if (x < m - 1) {
            Pair(x + 1, 0)
        } else {
            null
        }
    }

    fun backtrack(x: Int, y: Int) {
        if (x == 0 && y == 0) {
            for (i in 0..2) {
                grid[x][y] = i + 1
                val nextPost = getNextPost(x, y)
                if (nextPost != null) {
                    backtrack(nextPost.first, nextPost.second)
                }
            }
        } else if (x == 0) {
            for (i in 0..2) {
                if (grid[x][y - 1] == i + 1) {
                    continue
                }
                grid[x][y] = i + 1
                val nextPost = getNextPost(x, y)
                if (nextPost != null) {
                    backtrack(nextPost.first, nextPost.second)
                }
            }
        } else if (y == 0) {
            for (i in 0..2) {
                if (grid[x - 1][y] == i + 1) {
                    continue
                }
                grid[x][y] = i + 1
                val nextPost = getNextPost(x, y)
                if (nextPost != null) {
                    backtrack(nextPost.first, nextPost.second)
                }
            }
        } else {
            for (i in 0..2) {
                if (grid[x][y - 1] == i + 1 || grid[x - 1][y] == i + 1) {
                    continue
                }
                grid[x][y] = i + 1
                val nextPost = getNextPost(x, y)
                if (nextPost != null) {
                    backtrack(nextPost.first, nextPost.second)
                }
            }
        }
    }
    backtrack(0, 0)
    return result
}

private fun main() {

}
