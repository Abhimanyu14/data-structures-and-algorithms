package leetcode.leetcode_2185_counting_words_with_a_given_prefix

/**
 * leetcode - https://leetcode.com/problems/counting-words-with-a-given-prefix/
 *
 * Data Structure - NA
 * Algorithm - Built in methods - [startsWith] and [count]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 7 ms, faster than 87.50%
 * Memory Usage: 39.1 MB, less than 20.00%
 *
 * Time -
 * Space -
 */
private fun prefixCount(words: Array<String>, pref: String): Int {
    return words.count {
        it.startsWith(pref)
    }
}

/**
 * leetcode - https://leetcode.com/problems/counting-words-with-a-given-prefix/
 *
 * Using [startsWith] built in method
 *
 * Stats
 * Runtime: 356 ms, faster than 19.35%
 * Memory Usage: 38.7 MB, less than 74.19%
 */
private fun prefixCountUsingStartsWith(words: Array<String>, pref: String): Int {
    var count = 0
    words.forEach {
        if (it.startsWith(pref)) {
            count++
        }
    }
    return count
}

/**
 * leetcode - https://leetcode.com/problems/counting-words-with-a-given-prefix/
 *
 * Using substring string method
 *
 * Stats
 * Runtime: 409 ms, faster than 6.45%
 * Memory Usage: 39.5 MB, less than 51.61%
 */
fun prefixCountUsingSubstring(words: Array<String>, pref: String): Int {
    var count = 0
    words.forEach {
        if (it.length >= pref.length && it.substring(0, pref.length) == pref) {
            count++
        }
    }
    return count
}

private fun main() {

}
