package leetcode.leetcode_3000_to_3100.leetcode_3043_find_the_length_of_the_longest_common_prefix

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/solution/
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
    // Each node has up to 10 possible children (digits 0-9)
    var children: Array<TrieNode?> = arrayOfNulls(10)
}

internal class Trie {
    var root: TrieNode = TrieNode()

    // Insert a number into the Trie by treating it as a string of digits
    fun insert(num: Int) {
        var node: TrieNode? = root
        val numStr = num.toString()
        for (digit in numStr.toCharArray()) {
            val idx = digit.code - '0'.code
            if (node!!.children[idx] == null) {
                node.children[idx] = TrieNode()
            }
            node = node.children[idx]
        }
    }

    // Find the longest common prefix for a number in arr2 with the Trie
    fun findLongestPrefix(num: Int): Int {
        var node: TrieNode? = root
        val numStr = num.toString()
        var len = 0

        for (digit in numStr.toCharArray()) {
            val idx = digit.code - '0'.code
            if (node!!.children[idx] != null) {
                // Increase length if the current digit matches
                len++
                node = node.children[idx]
            } else {
                // Stop if no match for the current digit
                break
            }
        }
        return len
    }
}

private fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
    val trie = Trie()

    // Step 1: Insert all numbers from arr1 into the Trie
    for (num in arr1) {
        trie.insert(num)
    }

    var longestPrefix = 0

    // Step 2: Find the longest prefix match for each number in arr2
    for (num in arr2) {
        val len = trie.findLongestPrefix(num)
        longestPrefix = max(longestPrefix.toDouble(), len.toDouble()).toInt()
    }

    return longestPrefix
}

private fun main() {

}
