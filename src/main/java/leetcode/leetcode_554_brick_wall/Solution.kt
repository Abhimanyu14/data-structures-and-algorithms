package leetcode.leetcode_554_brick_wall

/**
 * leetcode - https://leetcode.com/problems/brick-wall/
 *
 * Using map
 *
 * Stats
 * Runtime: 257 ms, faster than 80.00%
 * Memory Usage: 44.8 MB, less than 86.67%
 */
private fun leastBricks(wall: List<List<Int>>): Int {
    val breaksCounter = mutableMapOf<Int, Int>()
    var current = 0
    wall.forEach { row ->
        current = 0
        for (i in 0..<row.lastIndex) {
            current += row[i]
            breaksCounter[current] = (breaksCounter[current] ?: 0) + 1
        }
    }
    if (breaksCounter.isEmpty()) {
        return wall.size
    }
    return wall.size - breaksCounter.values.max()
}

private fun main() {

}
