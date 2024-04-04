package leetcode.leet_1600_to_1699.leet_1614_maximum_nesting_depth_of_the_parentheses

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/submissions/
 *
 * Using counter variable
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 135 ms, faster than 68.75%
 * Memory Usage: 33.7 MB, less than 50.00%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun maxDepth(s: String): Int {
    var result = 0
    var current = 0
    s.forEach {
        if (it == '(') {
            current++
            result = max(result, current)
        } else if (it == ')') {
            current--
        }
    }
    return result
}

private fun main() {

}
