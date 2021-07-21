package leetcode.leet_208_prefix_tree

class Trie {
    private val data = mutableListOf<String>()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        data.add(word)
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        return data.contains(word)
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        return data.any {
            it.startsWith(prefix)
        }
    }
}

fun main() {
    val trie = Trie()
    println(trie.insert("hello"))
    println(trie.search("hell"))
    println(trie.search("helloa"))
    println(trie.search("hello"))
    println(trie.startsWith("hell"))
    println(trie.startsWith("helloa"))
    println(trie.startsWith("hello"))
}