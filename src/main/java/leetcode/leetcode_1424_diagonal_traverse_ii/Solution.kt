package leetcode.leetcode_1424_diagonal_traverse_ii

/**
 * leetcode - https://leetcode.com/problems/diagonal-traverse-ii/
 *
 * Data Structure - [Array], [List]
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 76 ms, faster than 91.67%
 * Memory Usage: 78.18 MB, less than 45.83%
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
    val result = mutableListOf<Int>()
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.addLast(Pair(0, 0))
    while(queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()
        result.add(nums[x][y])
        if (y == 0) {
            if (x + 1 <= nums.lastIndex) {
                queue.add(Pair(x + 1, 0))
            }
        }
        if (y + 1 <= nums[x].lastIndex) {
            queue.add(Pair(x, y + 1))
        }
    }
    return result.toIntArray()
}

private fun main() {

}
