package leetcode.leetcode_2828_check_if_a_string_is_an_acronym_of_words

/**
 * leetcode - https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/
 *
 * Data Structure - StringBuilder
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 3 ms, faster than 76.47%
 * Memory Usage: 37.9 MB, less than 47.06%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun isAcronym(words: List<String>, s: String): Boolean {
    val acronym = StringBuilder()
    for (word in words) {
        acronym.append(word[0])
    }
    return s == acronym.toString()
}

private fun main() {

}
