package leetcode.leet_2700_to_2799.leet_2706_buy_two_chocolates

/**
 * leetcode - https://leetcode.com/problems/buy-two-chocolates/?envType=daily-question&envId=2023-12-20
 *
 * Using iteration
 *
 * Stats
 * Runtime: 237 ms, faster than 21.43%
 * Memory Usage: 41.7 MB, less than 28.57%
 */
private fun buyChoco(prices: IntArray, money: Int): Int {
    var lowest: Int
    var next: Int
    if (prices[0] <= prices[1]) {
        lowest = prices[0]
        next = prices[1]
    } else {
        lowest = prices[1]
        next = prices[0]
    }
    for (i in 2..prices.lastIndex) {
        if (prices[i] <= lowest) {
            next = lowest
            lowest = prices[i]
        } else if (prices[i] <= next) {
            next = prices[i]
        }
    }
    return if (lowest + next > money) {
        money
    } else {
        money - (lowest + next)
    }
}

private fun main() {

}
