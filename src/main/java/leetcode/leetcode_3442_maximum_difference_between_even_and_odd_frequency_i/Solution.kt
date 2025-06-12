package leetcode.leetcode_3442_maximum_difference_between_even_and_odd_frequency_i

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/description/?envType=daily-question&envId=2025-06-10
 *
 * Data Structure - [IntArray]
 * Algorithm - Counting
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(26)
 *
 * Companies -
 */
private fun maxDifference(s: String): Int {
    val counter = IntArray(26)
    for (char in s) {
        counter[char - 'a']++
    }
    var maxOdd = 0
    var minEven = Int.MAX_VALUE
    for (i in 0..25) {
        if (counter[i] != 0) {
            if (counter[i] % 2 == 0) {
                minEven = min(minEven, counter[i])
            } else {
                maxOdd = max(maxOdd, counter[i])
            }
        }
    }
    return maxOdd - minEven
}

private fun main() {

}
