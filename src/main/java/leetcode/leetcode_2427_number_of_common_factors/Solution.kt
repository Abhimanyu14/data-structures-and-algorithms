package leetcode.leetcode_2427_number_of_common_factors

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/number-of-common-factors/submissions/1710932570/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google, Meta
 */
private fun commonFactors(a: Int, b: Int): Int {
    var result = 0
    for (i in 1..min(a, b)) {
        if (a % i == 0 && b % i == 0) {
            result++
        }
    }
    return result
}

private fun main() {

}
