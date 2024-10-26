package leetcode.leet_2400_to_2499.leet_2416_sum_of_prefix_scores_of_strings

/**
 * leetcode - https://leetcode.com/problems/sum-of-prefix-scores-of-strings/?envType=daily-question&envId=2024-09-25
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
    var next: Array<TrieNode?> = arrayOfNulls(26)
    var cnt: Int = 0
}

internal class Solution {
    // Initialize the root node of the trie.
    var root: TrieNode = TrieNode()

    // Insert function for the word.
    fun insert(word: String) {
        var node: TrieNode? = root
        for (c in word.toCharArray()) {
            // If new prefix, create a new trie node.
            if (node!!.next[c.code - 'a'.code] == null) {
                node.next[c.code - 'a'.code] = TrieNode()
            }
            // Increment the count of the current prefix.
            node.next[c.code - 'a'.code]!!.cnt++
            node = node.next[c.code - 'a'.code]
        }
    }

    // Calculate the prefix count using this function.
    fun count(s: String): Int {
        var node: TrieNode? = root
        var ans = 0
        // The ans would store the total sum of counts.
        for (c in s.toCharArray()) {
            ans += node!!.next[c.code - 'a'.code]!!.cnt
            node = node.next[c.code - 'a'.code]
        }
        return ans
    }

    fun sumPrefixScores(words: Array<String>): IntArray {
        val N = words.size
        // Insert words in trie.
        for (i in 0..<N) {
            insert(words[i])
        }
        val scores = IntArray(N)
        for (i in 0..<N) {
            // Get the count of all prefixes of given string.
            scores[i] = count(words[i])
        }
        return scores
    }
}

private fun main() {

}
