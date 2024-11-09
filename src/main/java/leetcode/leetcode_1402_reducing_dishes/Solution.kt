package leetcode.leetcode_1402_reducing_dishes

/**
 * leetcode - https://leetcode.com/problems/reducing-dishes/
 *
 * Using [sort]
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 18 ms, faster than 87.50%
 * Memory Usage: 37.6 MB, less than 81.82%
 *
 * Time -
 * Space -
 */
private fun maxSatisfaction(satisfaction: IntArray): Int {
    var result = 0
    satisfaction.sort()
    var index = satisfaction.lastIndex
    var current = satisfaction[index]
    if (current <= 0) {
        return 0
    }
    while (index > 0 && satisfaction[index - 1] + current > 0) {
        current += satisfaction[index - 1]
        index--
    }
    repeat(satisfaction.size - index) {
        result += ((it + 1) * satisfaction[index + it])
    }
    return result
}

private fun main() {

}
