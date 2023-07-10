package leetcode.leet_1800_to_1899.leet_1833_maximum_ice_cream_bars

/**
 * leetcode - https://leetcode.com/problems/maximum-ice-cream-bars/
 *
 * Using array sorting
 *
 * Stats
 * Runtime: 1036 ms, faster than 16.67%
 * Memory Usage: 77.8 MB, less than 44.44%
 */
private fun maxIceCream(costs: IntArray, coins: Int): Int {
    costs.sort()
    var costSoFar = 0
    var i = 0
    while (i < costs.size && costSoFar + costs[i] <= coins) {
        costSoFar += costs[i]
        i++
    }
    return i
}

/**
 * Note:
 * Leetcode mentions to use counting sort as it is O(N + M) time complexity.
 * Which is confusing as the range is large.
 */

private fun main() {

}
