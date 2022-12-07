package leetcode.leet_2100_to_2199.leet_2185_counting_words_with_a_given_prefix

/**
 * leetcode - https://leetcode.com/problems/counting-words-with-a-given-prefix/
 *
 * Using startsWith built in method
 *
 * Stats
 * Runtime: 356 ms, faster than 19.35%
 * Memory Usage: 38.7 MB, less than 74.19%
 */
private fun prefixCount(words: Array<String>, pref: String): Int {
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
