package leetcode.leetcode_2100_to_2199.leetcode_2147_number_of_ways_to_divide_a_long_corridor

/**
 * leetcode - https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/
 *
 * TODO(Abhi) - To revisit
 *
 * Using Combinatorics, Space Optimized
 *
 * Stats
 * Runtime: 334 ms, faster than 100.00%
 * Memory Usage: 40.3 MB, less than 100.00%
 */
private fun numberOfWays(corridor: String): Int {
    val mod = 1000_000_007

    // Total number of ways
    var result: Long = 1

    // Number of seats in the current section
    var seats = 0

    // Tracking Index of last S in the previous section
    var previousPairLast: Int? = null

    // Keep track of seats in corridor
    for (index in corridor.indices) {
        if (corridor[index] == 'S') {
            seats += 1

            // If two seats, then this is the last S in the section
            // Update seats for the next section
            if (seats == 2) {
                previousPairLast = index
                seats = 0
            } else if (seats == 1 && previousPairLast != null) {
                result *= (index - previousPairLast).toLong()
                result %= mod.toLong()
            }
        }
    }

    // If odd seats, or zero seats
    return if (seats == 1 || previousPairLast == null) {
        0
    } else {
        result.toInt()
    }
}

private fun main() {

}
