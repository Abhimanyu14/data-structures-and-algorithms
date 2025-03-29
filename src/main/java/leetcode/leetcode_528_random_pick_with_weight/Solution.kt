package leetcode.leetcode_528_random_pick_with_weight

/**
 * leetcode - https://leetcode.com/problems/random-pick-with-weight/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Using [random]
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private class Solution(w: IntArray) {
    private val prefixSums: IntArray = IntArray(w.size)
    private val totalSum: Int

    init {
        var prefixSum = 0
        for (i in w.indices) {
            prefixSum += w[i]
            prefixSums[i] = prefixSum
        }
        totalSum = prefixSum
    }

    fun pickIndex(): Int {
        val target = totalSum * Math.random()
        var i = 0
        while (i < prefixSums.size) {
            if (target < prefixSums[i]) {
                return i
            }
            i++
        }
        return i - 1
    }
}

private fun main() {

}
