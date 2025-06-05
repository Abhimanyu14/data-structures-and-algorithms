package leetcode.leetcode_3403_find_the_lexicographically_largest_string_from_the_box_i

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/?envType=daily-question&envId=2025-06-04
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Microsoft
 */
private fun answerString(word: String, numFriends: Int): String {
    if (numFriends == 1) {
        return word
    }
    fun lastSubstring(s: String): String {
        var i = 0
        var j = 1
        while (j < s.length) {
            var k = 0
            while (j + k < s.length && s[i + k] == s[j + k]) {
                k++
            }
            if (j + k < s.length && s[i + k] < s[j + k]) {
                val t = i
                i = j
                j = max((j + 1), (t + k + 1))
            } else {
                j = j + k + 1
            }
        }
        return s.substring(i)
    }

    val last = lastSubstring(word)
    return last.substring(0, min(last.length, (word.length - numFriends + 1)))
}

/**
 * leetcode - https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/?envType=daily-question&envId=2025-06-04
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Substring
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * N: Length of string
 * Time - O(N^2)
 * Space -
 *
 * Companies - Microsoft
 */
private fun answerStringUsingSubstring(word: String, numFriends: Int): String {
    if (numFriends == 1) {
        return word
    }

    fun getLexicographicallyLargest(word1: String, word2: String): String {
        for (i in 0..max(word1.lastIndex, word2.lastIndex)) {
            if (i > word1.lastIndex) {
                return word2
            }
            if (i > word2.lastIndex) {
                return word1
            }
            if (word1[i] > word2[i]) {
                return word1
            }
            if (word2[i] > word1[i]) {
                return word2
            }
        }
        return word1
    }

    var largestChar = word[0]
    var result = word.substring(0, word.length - (numFriends - 1))
    for (i in 1..word.lastIndex) {
        if (word[i] > largestChar) {
            result = word.substring(i, min(word.length, word.length - (numFriends - i - 1)))
            largestChar = word[i]
        } else if (word[i] == largestChar) {
            result = getLexicographicallyLargest(
                result,
                word.substring(i, min(word.length, word.length - (numFriends - i - 1)))
            )
        }
    }
    return result
}

private fun main() {

}
