package leetcode.leetcode_792_number_of_matching_subsequences

/**
 * leetcode - https://leetcode.com/problems/number-of-matching-subsequences/?envType=problem-list-v2&envId=trie
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Trie]
 * Algorithm -
 *
 * Source - https://youtu.be/Csqlac6k1U4
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun numMatchingSubseq(s: String, words: Array<String>): Int {
    var result = 0
    val positions = Array(26) { mutableListOf<Int>() }
    for (i in s.indices) {
        positions[s[i] - 'a'].add(i)
    }
    for (word in words) {
        val pointer = IntArray(26)
        var latestPosition = -1
        var isSubsequence = true
        for (char in word) {
            while (pointer[char - 'a'] <= positions[char - 'a'].lastIndex && positions[char - 'a'][pointer[char - 'a']] <= latestPosition) {
                pointer[char - 'a']++
            }
            if (pointer[char - 'a'] > positions[char - 'a'].lastIndex) {
                isSubsequence = false
                break
            } else {
                latestPosition = positions[char - 'a'][pointer[char - 'a']]
            }
        }
        if (isSubsequence) {
            println(word)
            result++
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/number-of-matching-subsequences/?envType=problem-list-v2&envId=trie
 *
 * Data Structure - [Trie]
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private class TrieNode(
    var wordCount: Int = 0,
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
        currentNode.wordCount++
    }

    fun countMatchingSubsequence(s: String): Int {
        val subsequences = mutableSetOf<Pair<String, Int>>()
        fun count(currentNode: TrieNode, index: Int, sub: String) {
            if (index > s.lastIndex) {
                return
            }
            currentNode.children[s[index] - 'a']?.let {
                count(it, index + 1, sub + s[index])
                if (it.wordCount > 0) {
                    subsequences.add(Pair(sub + s[index], it.wordCount))
                }
            }
            count(currentNode, index + 1, sub)
        }
        count(root, 0, "")
        return subsequences.sumOf { it.second }
    }
}

class Solution {
    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        val trie = Trie()
        for (word in words) {
            trie.add(word)
        }
        return trie.countMatchingSubsequence(s)
    }
}


private fun main() {

}
