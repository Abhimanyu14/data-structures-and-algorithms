package leetcode.leetcode_455_assign_cookies

/**
 * leetcode - https://leetcode.com/problems/assign-cookies/
 *
 * Using sorting and greedy
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 57 ms, faster than 25.81%
 * Memory Usage: 46.9 MB, less than 6.45%
 *
 * Time - Runtime: 57 ms, faster than 25.81%
 * Space - Memory Usage: 46.9 MB, less than 6.45%
 */
private fun findContentChildren(g: IntArray, s: IntArray): Int {
    var result = 0
    val sortedG = g.sorted()
    val sortedS = s.sorted()
    var gI = g.lastIndex
    var sI = s.lastIndex
    while (sI >= 0 && gI >= 0) {
        if (sortedS[sI] >= sortedG[gI]) {
            result++
            sI--
        }
        gI--
    }
    return result
}

private fun main() {

}
