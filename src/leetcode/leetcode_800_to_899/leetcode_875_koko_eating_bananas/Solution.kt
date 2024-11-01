package leetcode.leetcode_800_to_899.leetcode_875_koko_eating_bananas

import kotlin.math.ceil
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/koko-eating-bananas/
 *
 * Using binary search
 *
 * Binary search template - https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
 *
 * Stats
 * Runtime: 285 ms, faster than 40.36%
 * Memory Usage: 41 MB, less than 30.04%
 */
private fun minEatingSpeed(piles: IntArray, h: Int): Int {
    if (h < piles.size) {
        return -1 // Invalid input
    }
    if (h == piles.size) {
        return piles.max()
    }
    fun canCompleteEating(n: Int): Boolean {
        return piles.sumOf { ceil(it.toDouble() / n).toInt() } <= h
    }

    var left = 1
    var right = piles.max()
    while (left < right) {
        val mid = left + ((right - left) / 2)
        println("$left $right $mid")
        if (canCompleteEating(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

/**
 * leetcode - https://leetcode.com/problems/koko-eating-bananas/
 *
 * Using binary search
 *
 * Stats
 * Runtime: 286 ms, faster than 37.04%
 * Memory Usage: 41.7 MB, less than 7.87%
 */
private fun minEatingSpeedUsingBinarySearch(piles: IntArray, h: Int): Int {
    if (h <= piles.size) {
        return piles.max()
    }
    fun isPossible(n: Int): Boolean {
        var result = 0.0
        piles.forEach {
            result += ceil(it.toDouble() / n).toInt()
        }
        return result <= h
    }

    var pilesMax = 0
    var pilesSum = 0.0
    piles.forEach {
        pilesMax = max(pilesMax, it)
        pilesSum += it
    }
    val avg = ceil(pilesSum / h).toInt()
    var low = avg
    var high = pilesMax
    while (low < high) {
        val mid = low + ((high - low) / 2)
        if (isPossible(mid)) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return low
}

private fun main() {

}
