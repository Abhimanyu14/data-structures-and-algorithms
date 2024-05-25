package leetcode.leet_100_to_199.leet_140_word_break_ii


/**
 * leetcode - https://leetcode.com/problems/word-break-ii/?envType=daily-question&envId=2024-05-25
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Hard
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
    var root: TrieNode = TrieNode()

    fun insert(word: String) {
        var node: TrieNode? = root
        for (c in word.toCharArray()) {
            val index = c.code - 'a'.code
            if (node!!.children[index] == null) {
                node.children[index] = TrieNode()
            }
            node = node.children[index]
        }
        node!!.isEnd = true
    }
}

fun wordBreak(s: String, wordDict: List<String>): List<String> {
    // Build the Trie from the word dictionary
    val trie = Trie()
    for (word in wordDict) {
        trie.insert(word)
    }

    // Map to store results of sub problems
    val dp: MutableMap<Int, List<String>> = HashMap()

    // Iterate from the end of the string to the beginning
    for (startIdx in s.length downTo 0) {
        // List to store valid sentences starting from startIdx
        val validSentences: MutableList<String> = ArrayList()

        // Initialize current node to the root of the trie
        var currentNode: TrieNode? = trie.root

        // Iterate from startIdx to the end of the string
        for (endIdx in startIdx..<s.length) {
            val c = s[endIdx]
            val index = c.code - 'a'.code

            // Check if the current character exists in the trie
            if (currentNode!!.children[index] == null) {
                break
            }

            // Move to the next node in the trie
            currentNode = currentNode.children[index]

            // Check if we have found a valid word
            if (currentNode!!.isEnd) {
                val currentWord = s.substring(startIdx, endIdx + 1)

                // If it's the last word, add it as a valid sentence
                if (endIdx == s.length - 1) {
                    validSentences.add(currentWord)
                } else {
                    // If it's not the last word, append it to each sentence formed by the remaining substring
                    val sentencesFromNextIndex = dp[endIdx + 1]
                    if (sentencesFromNextIndex != null) {
                        for (sentence in sentencesFromNextIndex) {
                            validSentences.add(
                                "$currentWord $sentence"
                            )
                        }
                    }
                }
            }
        }

        // Store the valid sentences in dp
        dp[startIdx] = validSentences
    }

    // Return the sentences formed from the entire string
    return dp.getOrDefault(0, ArrayList())
}

private fun main() {

}
