package leetcode.leetcode_2241_design_an_atm_machine

import java.util.stream.IntStream
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/design-an-atm-machine/
 *
 * Data Structure - Array
 * Algorithm - Iteration and maths
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 125 ms, faster than 11.11%
 * Memory Usage: 52.8 MB, less than 81.82%
 *
 * Time - O(N)
 * Space - O(1)
 */
private class ATM {
    private var bank: Array<IntArray> = arrayOf(
        intArrayOf(20, 0),
        intArrayOf(50, 0),
        intArrayOf(100, 0),
        intArrayOf(200, 0),
        intArrayOf(500, 0),
    )

    fun deposit(banknotesCount: IntArray) {
        for (i in banknotesCount.indices) {
            bank[i][1] += banknotesCount[i]
        }
    }

    fun withdraw(amount: Int): IntArray {
        var remaining = amount
        val toRemove = IntArray(bank.size)
        for (i in bank.lastIndex downTo 0) {
            if (remaining <= 0) {
                break
            }
            toRemove[i] = min((remaining / bank[i][0]), bank[i][1])
            remaining -= (toRemove[i] * bank[i][0])
        }
        if (remaining > 0) {
            return intArrayOf(-1)
        }
        for (i in bank.indices) {
            bank[i][1] -= toRemove[i]
        }
        return toRemove
    }
}

private fun main() {

}
