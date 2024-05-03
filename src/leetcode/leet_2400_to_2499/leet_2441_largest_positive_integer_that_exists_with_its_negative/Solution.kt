package leetcode.leet_2400_to_2499.leet_2441_largest_positive_integer_that_exists_with_its_negative

import java.util.BitSet
import kotlin.math.abs


/**
 * leetcode - https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/?envType=daily-question&envId=2024-05-02
 *
 * TODO(Abhi) - To complete
 *
 * Using
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun findMaxK(nums: IntArray): Int {
    var ans = -1

    // Initialize a bitset to keep track of seen numbers
    val seen = BitSet(2048)

    for (num in nums) {
        val absNum = abs(num.toDouble()).toInt()

        // If the absolute value is greater than the current answer
        // and its negation was seen before,
        // update the answer
        if (absNum > ans && seen[-num + 1024]) ans = absNum
        // Mark the current number as seen
        seen.set(num + 1024)
    }

    return ans
}

private fun main() {

}
