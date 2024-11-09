package leetcode.leetcode_2824_count_pairs_whose_sum_is_less_than_target

/**
 * leetcode - https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
 *
 * Using [sorted]
 *
 * Difficulty - Easy
 *
 * Note:
 * 1. [List] does not have an in-place sort method
 *
 * Stats
 * Runtime: 21 ms, faster than 46.15%
 * Memory Usage: 38.1 MB, less than 37.50%
 *
 * Time -
 * Space -
 */
private fun countPairs(nums: List<Int>, target: Int): Int {
    if (nums.size <= 1) {
        return 0
    }
    var result = 0
    val sorted = nums.sorted()
    var first = 0
    var second = 1
    while (first < sorted.lastIndex) {
        while (second < sorted.lastIndex && ((sorted[first] + sorted[second + 1]) < target)) {
            second++
        }
        while (first < second && ((sorted[first] + sorted[second]) >= target)) {
            second--
        }
        if (first == second) {
            return result
        }
        result += (second - first)
        first++
    }
    return result
}

private fun main() {

}
