package leetcode.leet_200_to_299.leet_208_prefix_tree

/**
 * leetcode - https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * Using custom Trie implementation
 *
 * Stats
 * Runtime: 451 ms, faster than 16.88%
 * Memory Usage: 65 MB, less than 6.33%
 */
private data class TrieNode(
    val char: Char,
    val hasWord: Boolean = false,
    val children: MutableMap<Char, TrieNode> = mutableMapOf(),
)

private class Trie {
    private var heads = mutableMapOf<Char, TrieNode>()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        if (!heads.contains(word[0])) {
            heads[word[0]] = TrieNode(word[0])
        }
        if (word.length == 1) {
            heads[word[0]] = heads[word[0]]!!.copy(
                hasWord = true,
            )
        }
        var current = heads[word[0]]!!
        for (i in 1..word.lastIndex) {
            if (!current.children.contains(word[i])) {
                current.children[word[i]] = TrieNode(word[i])
            }
            if (i == word.lastIndex) {
                current.children[word[i]] = current.children[word[i]]!!.copy(hasWord = true)
            }
            current = current.children[word[i]]!!
        }
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var current = heads[word[0]] ?: return false
        for (i in 1..word.lastIndex) {
            current = current.children[word[i]] ?: return false
        }
        return current.hasWord
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var current = heads[prefix[0]] ?: return false
        for (i in 1..prefix.lastIndex) {
            current = current.children[prefix[i]] ?: return false
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
