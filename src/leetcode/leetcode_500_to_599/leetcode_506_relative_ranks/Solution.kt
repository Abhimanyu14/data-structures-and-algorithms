package leetcode.leetcode_500_to_599.leetcode_506_relative_ranks

/**
 * leetcode - https://leetcode.com/problems/relative-ranks/
 *
 * Using sorting and map
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun findRelativeRanks(score: IntArray): Array<String> {
    fun getResultString(pos: Int): String {
        return when (pos) {
            0 -> "Gold Medal"
            1 -> "Silver Medal"
            2 -> "Bronze Medal"
            else -> (pos + 1).toString()
        }
    }
    val sorted = score.sortedDescending()
    val map = sorted.mapIndexed { index, item ->
        item to index
    }.toMap()
    return score.map {
        getResultString(map.getOrDefault(it, 0))
    }.toTypedArray()
}

private fun main() {

}
