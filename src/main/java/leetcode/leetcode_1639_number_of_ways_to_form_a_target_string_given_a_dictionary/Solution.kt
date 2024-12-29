package leetcode.leetcode_1639_number_of_ways_to_form_a_target_string_given_a_dictionary

/**
 * leetcode - https://leetcode.com/classic/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/
 *
 * Data Structure - Map
 * Algorithm - Counting
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 */
private fun numWays(words: Array<String>, target: String): Int {
    val counters = Array(words[0].length) { IntArray(26) }
    for (i in words.indices) {
        for (j in words[i].indices) {
            counters[j][words[i][j] - 'a']++
        }
    }
    val memo = mutableMapOf<Pair<Int, Int>, Int>()
    fun explore(targetIndex: Int, wordIndex: Int): Int {
        memo[Pair(targetIndex, wordIndex)]?.let {
            return it
        }
        if (wordIndex < targetIndex) {
            memo[Pair(targetIndex, wordIndex)] = 0
            return 0
        }
        if (targetIndex == -1) {
            memo[Pair(targetIndex, wordIndex)] = 1
            return 1
        }
        val picked = explore(targetIndex - 1, wordIndex - 1)
        val skipped = explore(targetIndex, wordIndex - 1)
        memo[Pair(targetIndex, wordIndex)] =
            (((counters[wordIndex][target[targetIndex] - 'a'].toLong() * picked) + skipped) % 1_000_000_007).toInt()
        return memo[Pair(targetIndex, wordIndex)]!!
    }
    return explore(target.lastIndex, words[0].lastIndex)
}

private fun main() {

}
