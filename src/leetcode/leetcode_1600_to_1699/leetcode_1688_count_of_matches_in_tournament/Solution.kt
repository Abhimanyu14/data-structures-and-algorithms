package leetcode.leetcode_1600_to_1699.leetcode_1688_count_of_matches_in_tournament

/**
 * leetcode - https://leetcode.com/problems/count-of-matches-in-tournament/
 *
 * Using logic
 *
 * Stats
 * Runtime: 118 ms, faster than 78.26%
 * Memory Usage: 32.9 MB, less than 91.30%
 */
private fun numberOfMatches(n: Int): Int {
    return n - 1
}

/**
 * leetcode - https://leetcode.com/problems/count-of-matches-in-tournament/
 *
 * Using simulation
 *
 * Stats
 * Runtime: 141 ms, faster than 13.04%
 * Memory Usage: 33.5 MB, less than 17.39%
 */
private fun numberOfMatchesUsingSimulation(n: Int): Int {
    var result = 0
    var current = n
    while (current != 1) {
        result += current / 2
        current = (current + 1) / 2
    }
    return result
}

private fun main() {

}
