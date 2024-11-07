package leetcode.leetcode_528_random_pick_with_weight

/**
 * leetcode - https://leetcode.com/problems/random-pick-with-weight/
 *
 * Using random()
 *
 * Stats
 *
 */
private class Solution(w: IntArray) {
    private val prefixSums: IntArray
    private val totalSum: Int

    init {
        prefixSums = IntArray(w.size)
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
