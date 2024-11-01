package leetcode.leetcode_700_to_799.leetcode_787_cheapest_flights_within_k_stops

/**
 * leetcode - https://leetcode.com/problems/cheapest-flights-within-k-stops/
 *
 * TODO-Abhi: To revisit
 *
 * Using bellman ford
 *
 * Stats
 * Runtime: 196 ms, faster than 75.00%
 * Memory Usage: 38.1 MB, less than 89.29%
 */
private fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
    var dist = IntArray(n) { Int.MAX_VALUE }
    dist[src] = 0

    // Run only K+1 times since we want the shortest distance in K hops
    for (i in 0..k) {
        // Create a copy of dist vector.
        val temp = dist.copyOf(n)
        flights.forEach { (from, to, cost) ->
            if (dist[from] != Int.MAX_VALUE && ((dist[from] + cost) < temp[to])) {
                temp[to] = dist[from] + cost
            }
        }
        // Copy the temp vector into dist.
        dist = temp
    }

    return if (dist[dst] == Int.MAX_VALUE) {
        -1
    } else {
        dist[dst]
    }
}

private fun main() {

}
