package leetcode.leetcode_1424_diagonal_traverse_ii

/**
 * leetcode - https://leetcode.com/problems/diagonal-traverse-ii/
 *
 * Using BFS
 *
 * Stats
 * Runtime: 709 ms, faster than 54.55%
 * Memory Usage: 84 MB, less than 9.09%
 */
private fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
    val result = mutableListOf<Int>()
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.addLast(Pair(0, 0))
    while(queue.isNotEmpty()) {
        val temp = queue.removeFirst()
        result.add(nums[temp.first][temp.second])
        if (temp.second == 0) {
            if (temp.first + 1 <= nums.lastIndex) {
                queue.add(Pair(temp.first + 1, 0))
            }
        }
        if (temp.second + 1 <= nums[temp.first].lastIndex) {
            queue.add(Pair(temp.first, temp.second + 1))
        }
    }
    return result.toIntArray()
}

private fun main() {

}
