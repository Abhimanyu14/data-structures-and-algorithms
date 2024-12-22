package leetcode.leetcode_1010_pairs_of_songs_with_total_durations_divisible_by_60

/**
 * leetcode - https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
 * Data Structure - Map
 * Algorithm - Hashing
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 23 ms, faster than 73.33%
 * Memory Usage: 46.2 MB, less than 6.67%
 *
 * Time - O(N)
 * Space - O(60)
 */
private fun numPairsDivisibleBy60(time: IntArray): Int {
    var result = 0
    val counter = mutableMapOf<Int, Int>()
    for (t in time) {
        result += counter.getOrDefault((60 - (t % 60)) % 60, 0)
        counter[t % 60] = counter.getOrDefault(t % 60, 0) + 1
    }
    return result
}

private fun main() {

}
