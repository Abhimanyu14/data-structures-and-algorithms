package leetcode.leetcode_1200_to_1299.leetcode_1208_get_equal_substrings_within_budget

import kotlin.math.abs
import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/get-equal-substrings-within-budget/?envType=daily-question&envId=2024-05-28
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun equalSubstring(s: String, t: String, maxCost: Int): Int {
    var result = 0

    // Starting index of the current substring
    var start = 0

    // Cost of converting the current substring in s to t
    var currCost = 0

    for (i in s.indices) {
        // Add the current index to the substring
        currCost += abs((s[i] - t[i]))

        // Remove the indices from the left end till the cost becomes less than allowed
        while (currCost > maxCost) {
            currCost -= abs((s[start] - t[start]))
            start++
        }

        result = max(result, (i - start + 1))
    }
    return result
}

private fun main() {

}
