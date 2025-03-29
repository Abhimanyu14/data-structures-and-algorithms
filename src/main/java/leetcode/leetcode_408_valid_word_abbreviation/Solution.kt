package leetcode.leetcode_408_valid_word_abbreviation

/**
 * leetcode - https://leetcode.com/problems/valid-word-abbreviation/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 *
 * Data Structure - [String]
 * Algorithm - Iteration
 *
 * String methods - [isDigit], [digitToInt]
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(M + N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun validWordAbbreviation(word: String, abbr: String): Boolean {
    var digits: Int
    var i = 0
    var j = 0
    while (i < word.length && j < abbr.length) {
        if (abbr[j].isDigit()) {
            digits = 0
            if (abbr[j].digitToInt() == 0) {
                return false
            }
            while (j < abbr.length && abbr[j].isDigit()) {
                digits = (digits * 10) + abbr[j].digitToInt()
                j++
            }
            i += digits
        } else {
            if (word[i] == abbr[j]) {
                i++
                j++
            } else {
                return false
            }
        }
    }
    return i == word.length && j == abbr.length
}

private fun main() {

}
