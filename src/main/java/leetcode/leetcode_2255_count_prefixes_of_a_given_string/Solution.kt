package leetcode.leetcode_2255_count_prefixes_of_a_given_string

/**
 * leetcode - https://leetcode.com/problems/count-prefixes-of-a-given-string/
 *
 * Data Structure - NA
 * Algorithm - Built in methods - [startsWith] and [count]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 9 ms, faster than 40.00%
 * Memory Usage: 38.6 MB, less than 16.67%
 *
 * Time -
 * Space -
 */
private fun countPrefixes(words: Array<String>, s: String): Int {
    return words.count {
        s.startsWith(it)
    }
}

private fun main() {

}
