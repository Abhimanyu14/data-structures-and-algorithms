package leetcode.leetcode_342_power_of_four

import kotlin.math.ln
import kotlin.math.log2

/**
 * leetcode -  https://leetcode.com/problems/power-of-four/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Recursion (Tail recursion)
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(log (N))
 * Space - O(1) - As using tailrec
 *
 * Companies - Google
 */

/**
 * leetcode -  https://leetcode.com/problems/power-of-four/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - NA
 * Algorithm - Recursion (Tail recursion)
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(log (N))
 * Space - O(1) - As using tailrec
 *
 * Companies - Google
 */
private tailrec fun isPowerOfFourUsingRecursion(n: Int): Boolean {
    if (n == 1) {
        return true
    }
    if (n == 0 || n % 4 != 0) {
        return false
    }
    return isPowerOfFourUsingRecursion(n / 4)
}

/**
 * leetcode -  https://leetcode.com/problems/power-of-four/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 123 ms, faster than 95.59%
 * Memory Usage: 34.2 MB, less than 13.24%
 *
 * Time - O(log (N))
 * Space - O(1)
 *
 * Companies - Google
 */
private fun isPowerOfFourUsingIteration(n: Int): Boolean {
    var temp = n
    while (temp % 4 == 0 && temp > 0) {
        temp /= 4
    }
    return temp == 1
}
