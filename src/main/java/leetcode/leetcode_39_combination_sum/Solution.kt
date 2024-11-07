package leetcode.leetcode_39_combination_sum

/**
 * leetcode - https://leetcode.com/problems/combination-sum/solution/
 *
 * Using recursion / backtracking
 *
 * Stats
 * Runtime: 210 ms, faster than 86.30%
 * Memory Usage: 39 MB, less than 52.96%
 */
private fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val sorted = candidates.sorted().toList()
    val result = mutableListOf<List<Int>>()
    val current = mutableListOf<Int>()
    var temp: Int

    fun backtrack(current: List<Int>, currentPos: Int, sum: Int) {
        for (i in currentPos..sorted.lastIndex) {
            temp = sum + sorted[i]
            if (temp == target) {
                result.add(current + sorted[i])
            } else if (temp > target) {
                break
            } else {
                backtrack(current + sorted[i], i, sum + sorted[i])
            }
        }
    }

    backtrack(emptyList(), 0, 0)
    return result
}

private fun main() {

}
