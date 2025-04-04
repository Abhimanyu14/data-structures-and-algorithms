package leetcode.leetcode_2707_extra_characters_in_a_string

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/extra-characters-in-a-string/?envType=daily-question&envId=2024-09-23
 *
 * Data Structure - [Trie]
 * Algorithm - Trie and Dynamic Programming (memoization)
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private class TrieNode(
    var isWord: Boolean = false,
    val children: Array<TrieNode?> = arrayOfNulls(26),
)

private class Trie {
    private val root = TrieNode()

    fun add(word: String) {
        var currentNode = root
        for (char in word) {
            if (currentNode.children[char - 'a'] == null) {
                currentNode.children[char - 'a'] = TrieNode()
            }
            currentNode.children[char - 'a']?.let {
                currentNode = it
            }
        }
        currentNode.isWord = true
    }

    fun getExtraChars(s: String): Int {
        val cache = mutableMapOf<Int, Int>()
        fun getExtraChars(index: Int): Int {
            if (index == s.length) {
                return 0
            }
            cache[index]?.let {
                return it
            }
            var result = getExtraChars(index + 1) + 1
            var currentNode = root
            var currentIndex = index
            while (currentIndex < s.length && currentNode.children[s[currentIndex] - 'a'] != null) {
                currentNode.children[s[currentIndex] - 'a']?.let {
                    currentNode = it
                }
                currentIndex++
                if (currentNode.isWord) {
                    result = min(result, getExtraChars(currentIndex))
                }
            }
            cache[index] = result
            return result
        }
        return getExtraChars(0)
    }
}

private fun minExtraChar(s: String, dictionary: Array<String>): Int {
    val trie = Trie()
    for (word in dictionary) {
        trie.add(word)
    }
    return trie.getExtraChars(s)
}

private fun main() {

}
