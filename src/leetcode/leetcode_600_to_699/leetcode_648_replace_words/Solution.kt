package leetcode.leetcode_600_to_699.leetcode_648_replace_words

/**
 * leetcode - https://leetcode.com/problems/replace-words/?envType=daily-question&envId=2024-06-07
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */

internal class TrieNode {
    var isEnd: Boolean = false
    var children: Array<TrieNode?> = arrayOfNulls(26)
}

internal class Trie {
    private val root = TrieNode()

    fun insert(word: String) {
        var current: TrieNode? = root
        for (c in word.toCharArray()) {
            if (current!!.children[c - 'a'] == null) {
                current.children[c - 'a'] = TrieNode()
            }
            current = current.children[c - 'a']
        }
        current!!.isEnd = true
    }

    // Find the shortest root of the word in the trie
    fun shortestRoot(word: String): String {
        var current: TrieNode? = root
        for (i in word.indices) {
            val c = word[i]
            if (current!!.children[c - 'a'] == null) {
                // There is not a corresponding root in the trie
                return word
            }
            current = current.children[c - 'a']
            if (current!!.isEnd) {
                return word.substring(0, i + 1)
            }
        }
        // There is not a corresponding root in the trie
        return word
    }
}

private fun replaceWords(dictionary: List<String>, sentence: String): String {
    val wordArray = sentence.split(" ").dropLastWhile {
        it.isEmpty()
    }.toTypedArray()

    val trie = Trie()
    for (word in dictionary) {
        trie.insert(word)
    }

    // Replace each word in the sentence with the corresponding shortest root
    for (word in wordArray.indices) {
        wordArray[word] = trie.shortestRoot(wordArray[word])
    }

    return java.lang.String.join(" ", *wordArray)
}

private fun main() {

}
