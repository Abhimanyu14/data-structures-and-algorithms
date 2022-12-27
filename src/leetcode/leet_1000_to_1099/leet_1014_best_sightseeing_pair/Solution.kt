package leetcode.leet_1000_to_1099.leet_1014_best_sightseeing_pair

/**
 * leetcode - https://leetcode.com/problems/best-sightseeing-pair/
 *
 * Using
 *
 * Stats
 *
 */
private fun maxScoreSightseeingPair(values: IntArray): Int {
    var first = 0
    var second = 1
    var max = values[first] + values[second] + first - second
    for (i in 2..values.lastIndex) {
        val withFirst = values[first] + values[i] + first - i
        val withSecond = values[second] + values[i] + second - i
        if (withFirst > withSecond) {
            if (withFirst > max) {
                max = withFirst
                second = i
            }
        } else {
            if (withSecond > max) {
                max = withSecond
                first = i
            }
        }
    }
    return max
}

private fun main() {
    maxScoreSightseeingPair(intArrayOf(2, 7, 7, 2, 1, 7, 10, 4, 3, 3))
}
