package leetcode.leetcode_528_random_pick_with_weight

import kotlin.random.Random

/**
 * leetcode - https://leetcode.com/problems/random-pick-with-weight/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [IntArray], Two Pointers
 * Algorithm - Prefix Sum, Binary Search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Using [Random.nextInt]
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(log (N))
 * Space - O(N)
 *
 * Companies - Meta
 */
private class Solution(w: IntArray) {
    private val prefixSum = IntArray(w.size)

    init {
        var currentSum = 0
        for (i in w.indices) {
            currentSum += w[i]
            prefixSum[i] = currentSum
        }
    }

    fun pickIndex(): Int {
        val random = Random.nextInt(prefixSum.last())

        var left = 0
        var right = prefixSum.lastIndex
        while (left < right) {
            val mid = left + (right - left) / 2
            if (prefixSum[mid] > random) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }
}

private class SolutionUsingLinearSearch(w: IntArray) {
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
