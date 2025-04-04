package leetcode.leetcode_3043_find_the_length_of_the_longest_common_prefix

/**
 * leetcode - https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Trie]
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
internal class TrieNode {
    var children: Array<TrieNode?> = arrayOfNulls(10)
}

internal class Trie {
    var root: TrieNode = TrieNode()

    fun insert(num: Int) {
        var current = root
        for (digit in num.toString().toCharArray()) {
            val index = digit.digitToInt()
            if (current.children[index] == null) {
                current.children[index] = TrieNode()
            }
            current = current.children[index]!!
        }
    }

    fun findLongestPrefix(num: Int): Int {
        var current = root
        var prefixLength = 0
        for (digit in num.toString().toCharArray()) {
            val index = digit.digitToInt()
            if (current.children[index] != null) {
                prefixLength++
                current = current.children[index]!!
            } else {
                break
            }
        }
        return prefixLength
    }
}

class Solution {
    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        val trie = Trie()
        for (num in arr1) {
            trie.insert(num)
        }
        return arr2.maxOf { trie.findLongestPrefix(it) }
    }
}

private fun main() {

}
