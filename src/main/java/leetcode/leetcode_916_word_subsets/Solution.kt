package leetcode.leetcode_916_word_subsets

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/word-subsets/
 *
 * Data Structure - Array
 * Algorithm - Counting
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 20 ms, faster than 83.33%
 * Memory Usage: 50.7 MB, less than 83.33%
 *
 * Time -
 * Space -
 */
private fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
    val result = mutableListOf<String>()
    fun getCounter(str: String): IntArray {
        val counter = IntArray(26)
        for (char in str) {
            counter[char - 'a']++
        }
        return counter
    }

    val wordsCounter = IntArray(26)
    for (word in words2) {
        val counter = getCounter(word)
        for (i in 0..25) {
            wordsCounter[i] = max(wordsCounter[i], counter[i])
        }
    }
    for (word in words1) {
        val counter = getCounter(word)
        var flag = true
        for (i in 0..25) {
            if (wordsCounter[i] > counter[i]) {
                flag = false
                break
            }
        }
        if (flag) {
            result.add(word)
        }
    }
    return result
}

private fun main() {

}
