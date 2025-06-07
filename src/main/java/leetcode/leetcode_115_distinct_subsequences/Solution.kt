package leetcode.leetcode_115_distinct_subsequences

/**
 * TODO-Abhi: Optimize using 1D Array
 */

/**
 * leetcode - https://leetcode.com/problems/distinct-subsequences/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * Data Structure - [Array], [IntArray]
 * Algorithm - Backtrack - Recursion
 *
 * Difficulty - Hard
 *
 * Stats
 * M: s.length
 * N: t.length
 * Time - O(M*N)
 * Space - O(M*N)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun numDistinctUsing2DArray(s: String, t: String): Int {
    val cache = Array(s.length) {
        IntArray(t.length) { -1 }
    }

    fun backtrack(sIndex: Int, tIndex: Int): Int {
        if (tIndex == t.length) {
            return 1
        }
        if (sIndex == s.length) {
            return 0
        }
        if (cache[sIndex][tIndex] == -1) {
            cache[sIndex][tIndex] = if (s[sIndex] == t[tIndex]) {
                backtrack(sIndex + 1, tIndex + 1) + backtrack(sIndex + 1, tIndex)
            } else {
                backtrack(sIndex + 1, tIndex)
            }
        }
        return cache[sIndex][tIndex]
    }
    return backtrack(0, 0)
}

/**
 * leetcode - https://leetcode.com/problems/distinct-subsequences/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * Data Structure - [Map]
 * Algorithm - Backtrack - Recursion
 *
 * Difficulty - Hard
 *
 * Stats
 * M: s.length
 * N: t.length
 * Time - O(M*N)
 * Space - O(M*N)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun numDistinctUsingMap(s: String, t: String): Int {
    val cache = mutableMapOf<Pair<Int, Int>, Int>()
    fun backtrack(sIndex: Int, tIndex: Int): Int {
        if (tIndex == t.length) {
            return 1
        }
        if (sIndex == s.length) {
            return 0
        }
        if (cache[Pair(sIndex, tIndex)] == null) {
            cache[Pair(sIndex, tIndex)] = if (s[sIndex] == t[tIndex]) {
                backtrack(sIndex + 1, tIndex + 1) + backtrack(sIndex + 1, tIndex)
            } else {
                backtrack(sIndex + 1, tIndex)
            }
        }
        return cache[Pair(sIndex, tIndex)]!!
    }
    return backtrack(0, 0)
}

private fun main() {

}
