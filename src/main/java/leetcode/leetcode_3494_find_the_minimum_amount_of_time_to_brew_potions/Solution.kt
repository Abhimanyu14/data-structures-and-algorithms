package leetcode.leetcode_3494_find_the_minimum_amount_of_time_to_brew_potions

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/?envType=daily-question&envId=2025-10-09
 *
 * Data Structure - [LongArray]
 * Algorithm - Dynamic Programming
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * N: [skill.size]
 * M: [mana.size]
 * Time - O(M * N)
 * Space - O(N)
 *
 * Companies - Google
 */
private fun minTime(skill: IntArray, mana: IntArray): Long {
    val dp = LongArray(skill.size)
    dp[0] = skill[0].toLong() * mana[0]
    for (i in 1..skill.lastIndex) {
        dp[i] = dp[i - 1] + skill[i] * mana[0]
    }
    for (i in 1..mana.lastIndex) {
        dp[0] += skill[0] * mana[i]
        for (j in 1..skill.lastIndex) {
            dp[j] = max(dp[j], dp[j - 1]) + skill[j] * mana[i]
        }
        for (j in (skill.lastIndex - 1) downTo 0) {
            dp[j] = (dp[j + 1] - (mana[i] * skill[j + 1]))
        }
    }
    return dp.last()
}
