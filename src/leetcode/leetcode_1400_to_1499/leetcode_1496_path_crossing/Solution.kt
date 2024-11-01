package leetcode.leetcode_1400_to_1499.leetcode_1496_path_crossing

/**
 * leetcode - https://leetcode.com/problems/path-crossing/
 *
 * Using set
 *
 * Stats
 * Runtime: 153 ms, faster than 47.06%
 * Memory Usage: 35.3 MB, less than 47.06%
 */
private fun isPathCrossing(path: String): Boolean {
    fun getPoint(current: Pair<Int, Int>, path: Char): Pair<Int, Int> {
        return when (path) {
            'N' -> Pair(current.first, current.second + 1)
            'S' -> Pair(current.first, current.second - 1)
            'E' -> Pair(current.first + 1, current.second)
            else -> Pair(current.first - 1, current.second)
        }
    }
    val set = mutableSetOf<Pair<Int, Int>>()
    var current = Pair(0, 0)
    set.add(current)
    path.forEach {
        current = getPoint(current, it)
        if (set.contains(current)) {
            return true
        }
        set.add(current)
    }
    return false
}

private fun main() {

}
