package leetcode.leetcode_1967_number_of_strings_that_appear_as_substrings_in_word

/**
 * leetcode - https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/?envType=company&envId=uber&favoriteSlug=uber-all
 *
 * TODO(Abhi) - To revisit, try using Trie / K-D Tree
 *
 * Data Structure - Strings
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(M * N)
 * Space - O(1)
 *
 * Companies -
 */
private fun numOfStrings(patterns: Array<String>, word: String): Int {
    var count = 0
    for (pattern in patterns) {
        if (word.contains(pattern)) {
            count++
        }
    }
    return count
}

private fun main() {

}
