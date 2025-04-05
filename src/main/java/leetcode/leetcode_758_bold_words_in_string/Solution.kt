package leetcode.leetcode_758_bold_words_in_string

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/bold-words-in-string/description/?envType=problem-list-v2&envId=trie
 * Premium Question
 *
 * Data Structure - [Trie]
 * Algorithm -
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

    fun boldIndex(s: String, startIndex: Int): Int {
        var result = -1
        var currentIndex = startIndex
        var currentNode: TrieNode? = root
        while (currentIndex <= s.lastIndex && currentNode != null) {
            currentNode = currentNode.children[s[currentIndex] - 'a']
            if (currentNode != null && currentNode.isWord) {
                result = max(result, currentIndex)
            }
            currentIndex++
        }
        return result
    }
}

class Solution {
    fun boldWords(words: Array<String>, s: String): String {
        val result = StringBuilder()
        val trie = Trie()
        val boldIndices = BooleanArray(s.length)
        for (word in words) {
            trie.add(word)
        }
        for (i in s.indices) {
            val endIndex = trie.boldIndex(s, i)
            for (x in i..endIndex) {
                boldIndices[x] = true
            }
        }
        var i = 0
        while (i <= s.lastIndex) {
            while ((i <= s.lastIndex) && !boldIndices[i]) {
                result.append(s[i])
                i++
            }
            if (i <= s.lastIndex) {
                result.append("<b>")
                while ((i <= s.lastIndex) && boldIndices[i]) {
                    result.append(s[i])
                    i++
                }
                result.append("</b>")
            }
        }
        return result.toString()
    }
}


private fun main() {

}
