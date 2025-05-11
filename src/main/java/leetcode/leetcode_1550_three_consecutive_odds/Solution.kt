package leetcode.leetcode_1550_three_consecutive_odds

/**
 * leetcode - https://leetcode.com/problems/three-consecutive-odds/description/?envType=daily-question&envId=2025-05-11
 *
 * Data Structure - NA
 * Algorithm - Counting & Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Amazon, Google
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
