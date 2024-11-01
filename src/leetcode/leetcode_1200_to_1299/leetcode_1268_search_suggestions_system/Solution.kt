package leetcode.leetcode_1200_to_1299.leetcode_1268_search_suggestions_system

/**
 * leetcode - https://leetcode.com/problems/search-suggestions-system
 *
 * Using Trie
 *
 * Stats
 * Runtime: 541 ms, faster than 34.09%
 * Memory Usage: 52.8 MB, less than 45.45%
 */
private class TrieNode(
    val char: Char,
    val children: Array<TrieNode?> = Array(26) { null },
    var isWord: Boolean = false,
)

private class SearchSuggestionSystem {
    private val rootNodes = Array(26) { TrieNode('a' + it) }

    fun addWord(word: String) {
        if (word.length == 1) {
            rootNodes[word[0] - 'a'].isWord = true
        } else {
            var current = rootNodes[word[0] - 'a']
            for (i in 1..word.lastIndex) {
                if (current.children[word[i] - 'a'] == null) {
                    current.children[word[i] - 'a'] = TrieNode(word[i])
                }
                current = current.children[word[i] - 'a']!!
            }
            current.isWord = true
        }
    }

    fun getSuggestions(word: String, count: Int = 3): List<String> {
        var current = rootNodes[word[0] - 'a']
        for (i in 1..word.lastIndex) {
            current = current.children[word[i] - 'a'] ?: return emptyList()
        }
        val result = mutableListOf<String>()
        fun findWords(node: TrieNode, currentWord: String) {
            if (result.size == count) {
                return
            }
            if (node.isWord) {
                result.add(currentWord)
            }
            node.children.forEachIndexed { index, trieNode ->
                if (trieNode != null) {
                    findWords(trieNode, currentWord + trieNode.char)
                }
            }
        }
        findWords(current, word)
        return result
    }
}

private fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
    val searchSuggestionSystem = SearchSuggestionSystem()
    products.forEach {
        searchSuggestionSystem.addWord(it)
    }
    val result = mutableListOf<List<String>>()
    for (i in searchWord.indices) {
        result.add(searchSuggestionSystem.getSuggestions(searchWord.substring(0..i)))
    }
    return result
}

private fun main() {
    println(
        suggestedProducts(
            arrayOf("mobile", "mouse", "moneypot", "monitor", "mousepad"),
            "mouse"
        ).joinToString(", ")
    )
}
