package leetcode.leet_1500_to_1599.leet_1550_three_consecutive_odds

/**
 * leetcode - https://leetcode.com/problems/three-consecutive-odds/
 *
 * Using counting and loop
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 161 ms, faster than 33.33%
 * Memory Usage: 35 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun threeConsecutiveOdds(arr: IntArray): Boolean {
    var count = 0
    for (num in arr) {
        if (num % 2 == 1) {
            count++
            if (count == 3) {
                return true
            }
        } else {
            count = 0
        }
    }
    return false
}

private fun main() {

}
