package leetcode.leetcode_2073_time_needed_to_buy_tickets

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/time-needed-to-buy-tickets/?envType=daily-question&envId=2024-04-09
 *
 * Using loop
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 145 ms, faster than 63.64%
 * Memory Usage: 33.8 MB, less than 90.91%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
    var result = 0
    tickets.forEachIndexed { index, ticket ->
        result += if (index <= k) {
            min(tickets[k], ticket)
        } else {
            min(tickets[k] - 1, ticket)
        }
    }
    return result
}

private fun main() {

}
