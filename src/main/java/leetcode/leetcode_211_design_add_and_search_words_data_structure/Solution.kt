package leetcode.leetcode_211_design_add_and_search_words_data_structure

/**
 * leetcode - https://leetcode.com/problems/design-add-and-search-words-data-structure/
 *
 * Data Structure - Trie
 * Algorithm -
 *
 * Difficulty -
 *
 * Stats
 * Runtime: 307 ms, faster than 44.44%
 * Memory Usage: 127.4 MB, less than 18.13%
 *
 * Time -
 * Space -
 */
private class TrieNode(
    var isWord: Boolean = false,
    var children: MutableMap<Int, TrieNode> = mutableMapOf(),
)

class WordDictionary() {
    private val roots = Array(26) { TrieNode() }

    fun addWord(word: String) {
        if (word.length == 1) {
            roots[word[0] - 'a'].isWord = true
        } else {
            var currentNode = roots[word[0] - 'a']
            for (i in 1..word.lastIndex) {
                if (!currentNode.children.contains(word[i] - 'a')) {
                    currentNode.children[word[i] - 'a'] = TrieNode()
                }
                currentNode = currentNode.children[word[i] - 'a']!!
            }
            currentNode.isWord = true
        }
    }

    fun search(word: String): Boolean {
        if (word[0] == '.') {
            for (i in 0..25) {
                if (search(word, 1, roots[i])) {
                    return true
                }
            }
            return false
        } else {
            return search(word, 1, roots[word[0] - 'a'])
        }
    }

    private fun search(word: String, index: Int, current: TrieNode): Boolean {
        if (index == word.length) {
            return current.isWord
        }
        if (word[index] == '.') {
            for ((key, value) in current.children) {
                if (search(word, index + 1, value)) {
                    return true
                }
            }
            return false
        } else if (current.children.contains(word[index] - 'a')) {
            return search(word, index + 1, current.children[word[index] - 'a']!!)
        } else {
            return false
        }
    }
}

private fun main() {

}
