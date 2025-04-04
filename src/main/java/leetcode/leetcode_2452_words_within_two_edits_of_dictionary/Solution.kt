package leetcode.leetcode_2452_words_within_two_edits_of_dictionary

/**
 * leetcode - https://leetcode.com/problems/words-within-two-edits-of-dictionary/description/?envType=problem-list-v2&envId=trie
 *
 * Data Structure - [Trie]
 * Algorithm - Trie
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
    val root = TrieNode()

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

    fun isMatching(s: String): Boolean {
        fun isMatching(currentNode: TrieNode, index: Int, remaining: Int): Boolean {
            if (index == s.length && currentNode.isWord) {
                return true
            }
            currentNode.children[s[index] - 'a']?.let {
                if (isMatching(it, index + 1, remaining)) {
                    return true
                }
            }
            if (remaining > 0) {
                currentNode.children.forEach {
                    it?.let {
                        if (isMatching(it, index + 1, remaining - 1)) {
                            return true
                        }
                    }
                }
            }
            return false
        }
        return isMatching(root, 0, 2)
    }
}

class Solution {
    fun twoEditWords(queries: Array<String>, dictionary: Array<String>): List<String> {
        val result = mutableListOf<String>()
        val trie = Trie()
        for (word in dictionary) {
            trie.add(word)
        }
        for (word in queries) {
            if (trie.isMatching(word)) {
                result.add(word)
            }
        }
        return result
    }
}

private fun main() {

}
