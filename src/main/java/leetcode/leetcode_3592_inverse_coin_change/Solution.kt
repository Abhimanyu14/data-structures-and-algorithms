package leetcode.leetcode_3592_inverse_coin_change

/**
 * leetcode - https://leetcode.com/problems/inverse-coin-change/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - [IntArray], [List]
 * Algorithm - Dynamic Programming
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N ^ 2)
 * Space - O(N)
 *
 * Companies - Google
 */
private fun findCoins(numWays: IntArray): List<Int> {
    val result = mutableListOf<Int>()
    val current = IntArray(numWays.size)
    for (i in numWays.indices) {
        if (current[i] == numWays[i]) {
            continue
        }
        if (current[i] != numWays[i] - 1) {
            return emptyList()
        }
        result.add(i + 1)
        current[i]++
        for (j in (i + 1)..numWays.lastIndex) {
            current[j] += current[j - i - 1]
        }
    }
    return result
}

private fun main() {

}
