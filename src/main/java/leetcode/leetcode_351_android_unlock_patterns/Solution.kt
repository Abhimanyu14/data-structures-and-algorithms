package leetcode.leetcode_351_android_unlock_patterns

/**
 * leetcode - https://leetcode.com/problems/android-unlock-patterns/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Set]
 * Algorithm - Backtracking, Dynamic Programming, Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google
 */
private fun numberOfPatterns(m: Int, n: Int): Int {
    var result = 0
    val dp = IntArray(n + 1)
    val skips = mutableMapOf(
        Pair(1, 3) to 2,
        Pair(3, 1) to 2,
        Pair(1, 7) to 4,
        Pair(7, 1) to 4,
        Pair(3, 9) to 6,
        Pair(9, 3) to 6,
        Pair(7, 9) to 8,
        Pair(9, 7) to 8,
        Pair(1, 9) to 5,
        Pair(9, 1) to 5,
        Pair(3, 7) to 5,
        Pair(7, 3) to 5,
        Pair(2, 8) to 5,
        Pair(8, 2) to 5,
        Pair(4, 6) to 5,
        Pair(6, 4) to 5,
    )

    val current = mutableSetOf<Int>()
    fun backtrack(last: Int) {
        dp[current.size]++
        if (current.size == n) {
            return
        }
        for (i in 1..9) {
            if (i == last || current.contains(i)) {
                continue
            }
            if (!skips.contains(Pair(last, i)) || current.contains(skips[Pair(last, i)]!!)) {
                current.add(i)
                backtrack(i)
                current.remove(i)
            }
        }
    }

    for (i in 1..9) {
        current.add(i)
        backtrack(i)
        current.remove(i)
    }

    for (i in m..n) {
        result += dp[i]
    }
    return result
}

private fun main() {

}
