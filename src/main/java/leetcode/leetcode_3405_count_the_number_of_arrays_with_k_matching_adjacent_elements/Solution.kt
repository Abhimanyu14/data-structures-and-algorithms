package leetcode.leetcode_3405_count_the_number_of_arrays_with_k_matching_adjacent_elements

import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/?envType=daily-question&envId=2025-06-17
 *
 * TODO - To revisit
 *
 * Data Structure -
 * Algorithm - Backtracking (Recursion)
 *
 * Difficulty -
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun countGoodArrays(n: Int, m: Int, k: Int): Int {
    var result = 0
    val mod = 1_000_000_007

    val cache = mutableMapOf<Pair<Int, Int>, Int>()
    fun backtrack(index: Int, remaining: Int, previous: Int): Int {
        cache[Pair(index, remaining)]?.let {
            return it
        }
        if (index == n) {
            cache[Pair(index, remaining)] = 0
            return 0
        }
        if (remaining == n - index) {
            cache[Pair(index, remaining)] = 1
            return 1
        }
        if (remaining == 0) {
            cache[Pair(index, remaining)] = ((m.toDouble() - 1).pow(n - index) % mod).toInt()
            return cache[Pair(index, remaining)]!!
        }
        var count = 0
        for (i in 1..m) {
            count = if (previous == i) {
                (count + backtrack(index + 1, remaining - 1, i)) % mod
            } else {
                (count + backtrack(index + 1, remaining, i)) % mod
            }
        }
        cache[Pair(index, remaining)] = count
        return cache[Pair(index, remaining)]!!
    }
    for (i in 1..m) {
        result = (result + backtrack(1, k, i)) % mod
    }
    return result
}

private fun main() {

}
