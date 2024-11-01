package leetcode.leetcode_300_to_399.leetcode_374_guess_number_higher_or_lower

/**
 * leetcode - https://leetcode.com/problems/guess-number-higher-or-lower/
 *
 * Using binary search
 *
 * Stats
 * Runtime: 115 ms, faster than 84.75%
 * Memory Usage: 33.2 MB, less than 7.91%
 */
private class Solution {
    fun guess(m: Int): Int {
        return 0
    }

    fun guessNumber(n: Int): Int {
        var low = 1
        var high = n
        var mid = low + (high - low) / 2
        while (true) {
            when (guess(mid)) {
                0 -> {
                    return mid
                }

                1 -> {
                    low = mid + 1
                }

                -1 -> {
                    high = mid - 1
                }
            }
            mid = low + (high - low) / 2
        }
        return 0
    }
}

private fun main() {

}
