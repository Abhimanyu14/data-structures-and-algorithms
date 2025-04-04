package leetcode.leetcode_1268_search_suggestions_system

/**
 * leetcode - https://leetcode.com/problems/search-suggestions-system
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Trie], [ArrayDeque] (Stack)
 * Algorithm - Trie and DFS
 *
 * Using array methods - [arrayOfNulls]
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 104 ms, faster than 27.78%
 * Memory Usage: 59.73 MB, less than 19.44%
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

    fun getSuggestions(word: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        var currentNode: TrieNode? = root
        val stringBuilder = StringBuilder()
        for (char in word) {
            currentNode = currentNode?.children?.get(char - 'a')
            if (currentNode == null) {
                result.add(emptyList())
            } else {
                stringBuilder.append(char)
                result.add(getWords(currentNode, stringBuilder.toString()))
            }
        }
        return result
    }

    private fun getWords(node: TrieNode, prefix: String): List<String> {
        val result = mutableListOf<String>()
        val stack = ArrayDeque<Pair<TrieNode, String>>()
        stack.addLast(Pair(node, prefix))
        while (stack.isNotEmpty() && result.size < 3) {
            val (currentNode, currentString) = stack.removeLast()
            if (currentNode.isWord) {
                result.add(currentString)
            }
            var i = 25
            while (i >= 0 && result.size < 3) {
                currentNode.children[i]?.let {
                    stack.addLast(Pair(it, currentString + ('a' + i)))
                }
                i--
            }
        }
        return result
    }
}

private fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
    val trie = Trie()
    for (product in products) {
        trie.add(product)
    }
    return trie.getSuggestions(searchWord)
}

private fun main() {
    println(
        suggestedProducts(
            arrayOf("mobile", "mouse", "moneypot", "monitor", "mousepad"),
            "mouse"
        ).joinToString(", ")
    )
}
