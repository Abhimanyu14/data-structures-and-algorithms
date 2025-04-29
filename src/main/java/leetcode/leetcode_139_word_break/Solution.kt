package leetcode.leetcode_139_word_break

/**
 * leetcode - https://leetcode.com/problems/word-break/?envType=problem-list-v2&envId=hash-table&
 *
 * TODO(Abhi) - To revisit
 *
 * Using brute force
 *
 * Source - https://youtu.be/Sx9NNgInc3A?si=MtkbbHo1Ts-1ibcL
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 13 ms, faster than 59.26%
 * Memory Usage: 37.5 MB, less than 40.79%
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
    val cache = mutableMapOf<Pair<String, Int>, Boolean>()

    fun add(word: String) {
        var current = root
        for (i in word.indices) {
            if (current.children[word[i] - 'a'] == null) {
                current.children[word[i] - 'a'] = TrieNode()
            }
            current = current.children[word[i] - 'a']!!
        }
        current.isWord = true
    }

    fun find(word: String, start: Int = 0): Boolean {
        cache[Pair(word, start)]?.let {
            return it
        }
        if (start > word.lastIndex) {
            cache[Pair(word, start)] = true
            return true
        }
        var current = root
        for (i in start..word.lastIndex) {
            if (current.children[word[i] - 'a'] == null) {
                cache[Pair(word, start)] = false
                return false
            }
            current = current.children[word[i] - 'a']!!
            if (current.isWord && find(word, i + 1)) {
                cache[Pair(word, start)] = true
                return true
            }
        }
        cache[Pair(word, start)] = current.isWord
        return current.isWord
    }
}

private fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val trie = Trie()
    for (word in wordDict) {
        trie.add(word)
    }
    return trie.find(s)
}

/**
 * leetcode - https://leetcode.com/problems/word-break/?envType=problem-list-v2&envId=hash-table&
 *
 * TODO(Abhi) - To revisit
 *
 * Using brute force
 *
 * Source - https://youtu.be/Sx9NNgInc3A?si=MtkbbHo1Ts-1ibcL
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 13 ms, faster than 59.26%
 * Memory Usage: 37.5 MB, less than 40.79%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun wordBreakUsingBruteForce(s: String, wordDict: List<String>): Boolean {
    val dp = BooleanArray(s.length + 1) { false }
    dp[s.length] = true
    for (i in s.lastIndex downTo 0) {
        for (word in wordDict) {
            if ((i + word.length <= s.length) && (s.substring(i, i + word.length) == word) && dp[i + word.length]) {
                dp[i] = true
                break
            }
        }
    }
    return dp[0]
}

private fun main() {

}
