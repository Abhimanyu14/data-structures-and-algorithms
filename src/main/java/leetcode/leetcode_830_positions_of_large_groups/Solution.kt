package leetcode.leetcode_830_positions_of_large_groups

/**
 * leetcode - https://leetcode.com/problems/positions-of-large-groups/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 25 ms, faster than 12.50%
 * Memory Usage: 41.7 MB, less than 5.56%
 *
 * Time -
 * Space -
 */
private fun largeGroupPositions(s: String): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    var count = 1
    var index = 0
    for (i in 1..s.lastIndex) {
        if (s[i] == s[i - 1]) {
            count++
        } else {
            if (count >= 3) {
                result.add(listOf(index, i - 1))
            }
            count = 1
            index = i
        }
    }
    return result
}

private fun main() {

}
