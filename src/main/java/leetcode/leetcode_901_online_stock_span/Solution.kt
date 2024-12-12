package leetcode.leetcode_901_online_stock_span

import java.util.Stack

/**
 * leetcode - https://leetcode.com/problems/online-stock-span/
 * https://leetcode.com/problems/online-stock-span/description/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=MEDIUM
 *
 * Data Structure - Monotonic Stack
 * Algorithm - Monotonic Stack
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 117 ms, faster than 34.12%
 * Memory Usage: 72.9 MB, less than 5.32%
 *
 * Time - O(N)
 * Space - O(N)
 */
private class StockSpanner() {
    private var day = 0
    private val stack = Stack<Triple<Int, Int, Int>>() // Price, day, result

    fun next(price: Int): Int {
        day++
        while (stack.isNotEmpty() && stack.peek().first < price) {
            stack.pop()
        }
        val result = if (stack.isEmpty()) {
            day
        } else {
            if (stack.peek().first == price) {
                day - stack.peek().second + stack.peek().third
            } else {
                day - stack.peek().second
            }
        }
        stack.push(Triple(price, day, result))
        return result
    }
}

private fun main() {

}
