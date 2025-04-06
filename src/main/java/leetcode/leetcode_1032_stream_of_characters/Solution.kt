package leetcode.leetcode_1032_stream_of_characters

/**
 * leetcode - https://leetcode.com/problems/stream-of-characters/?envType=problem-list-v2&envId=trie
 *
 * Data Structure - [Trie], [StringBuilder]
 * Algorithm -
 *
 * String properties - [lastIndex]
 *
 * Difficulty - Hard
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
        for (i in word.lastIndex downTo 0) {
            if (currentNode.children[word[i] - 'a'] == null) {
                currentNode.children[word[i] - 'a'] = TrieNode()
            }
            currentNode.children[word[i] - 'a']?.let {
                currentNode = it
            }
        }
        currentNode.isWord = true
    }

    fun matchFound(word: String): Boolean {
        var currentNode: TrieNode? = root
        var index = word.lastIndex
        while (index >= 0 && currentNode != null) {
            currentNode = currentNode.children[word[index] - 'a']
            if (currentNode?.isWord == true) {
                return true
            }
            index--
        }
        return false
    }
}

class StreamChecker(words: Array<String>) {
    private val trie = Trie()
    private val stringBuilder = StringBuilder()

    init {
        for (word in words) {
            trie.add(word)
        }
    }

    fun query(letter: Char): Boolean {
        stringBuilder.append(letter)
        return trie.matchFound(stringBuilder.toString())
    }
}

private fun main() {

}
