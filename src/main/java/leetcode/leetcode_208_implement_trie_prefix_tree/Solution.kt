package leetcode.leetcode_208_implement_trie_prefix_tree

/**
 * leetcode - https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * Data Structure - [Trie]
 * Algorithm - Trie
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 66 ms, faster than 95.37%
 * Memory Usage: 61.98 MB, less than 45.91%
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

class Trie {
    private val root = TrieNode()

    fun insert(word: String) {
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

    fun search(word: String): Boolean {
        var currentNode = root
        for (char in word) {
            currentNode = currentNode.children[char - 'a'] ?: return false
        }
        return currentNode.isWord
    }

    fun startsWith(prefix: String): Boolean {
        var currentNode = root
        for (char in prefix) {
            currentNode = currentNode.children[char - 'a'] ?: return false
        }
        return true
    }
}

private fun main() {
    val trie = Trie()
    println(trie.insert("app"))
    println(trie.insert("apple"))
    println(trie.search("app"))
    println(trie.insert("beer"))
    println(trie.insert("add"))
    println(trie.insert("jam"))
    println(trie.insert("rental"))
    println(trie.search("apps"))

//    ["Trie",
//        "insert",
//        "insert",
//        "insert",
//        "insert",
//        "insert",
//        "insert",
//        "search",
//        "search",
//        "search",
//        "search",
//        "search",
//        "search",
//        "search",
//        "search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
//    [[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]
}
