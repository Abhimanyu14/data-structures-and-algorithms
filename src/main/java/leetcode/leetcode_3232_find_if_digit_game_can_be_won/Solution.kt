package leetcode.leetcode_3232_find_if_digit_game_can_be_won

/**
 * leetcode - https://leetcode.com/problems/find-if-digit-game-can-be-won/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 39.3 MB, less than 27.59%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun canAliceWin(nums: IntArray): Boolean {
    var singleDigitNumbersSum = 0
    var doubleDigitNumbersSum = 0
    nums.forEach {
        if (it < 10) {
            singleDigitNumbersSum += it
        } else {
            doubleDigitNumbersSum += it
        }
    }
    return singleDigitNumbersSum != doubleDigitNumbersSum
}

private fun main() {

}
