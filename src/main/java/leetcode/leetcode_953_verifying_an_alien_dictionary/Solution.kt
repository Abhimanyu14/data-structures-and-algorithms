package leetcode.leetcode_953_verifying_an_alien_dictionary

import kotlin.math.min

/**
 * TODO(Abhi) - using Array
 */
/**
 * leetcode - https://leetcode.com/problems/verifying-an-alien-dictionary/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 *
 * Data Structure - [Map]
 * Algorithm - Hashing, Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(26)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun isAlienSorted(words: Array<String>, order: String): Boolean {
    val charIndexMap = mutableMapOf<Char, Int>()
    for (i in order.indices) {
        charIndexMap[order[i]] = i
    }
    fun isValid(word1: String, word2: String): Boolean {
        var index = 0
        while (index <= min(word1.lastIndex, word2.lastIndex) && word1[index] == word2[index]) {
            index++
        }
        if (index <= min(word1.lastIndex, word2.lastIndex)) {
            return charIndexMap[word1[index]]!! < charIndexMap[word2[index]]!!
        }
        return word2.lastIndex >= word1.lastIndex
    }
    for (i in 1..words.lastIndex) {
        if (!isValid(words[i - 1], words[i])) {
            return false
        }
    }
    return true
}

private fun main() {

}
