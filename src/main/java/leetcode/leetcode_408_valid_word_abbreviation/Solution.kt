package leetcode.leetcode_408_valid_word_abbreviation

/**
 * leetcode - https://leetcode.com/problems/valid-word-abbreviation/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 * Premium Question
 *
 * Data Structure - [String], Two Pointers
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
    var wordIndex = 0
    var abbrIndex = 0
    while (wordIndex < word.length && abbrIndex < abbr.length) {
        if (abbr[abbrIndex].isDigit()) {
            digits = 0
            if (abbr[abbrIndex].digitToInt() == 0) {
                return false
            }
            while (abbrIndex < abbr.length && abbr[abbrIndex].isDigit()) {
                digits = (digits * 10) + abbr[abbrIndex].digitToInt()
                abbrIndex++
            }
            wordIndex += digits
        } else {
            if (word[wordIndex] == abbr[abbrIndex]) {
                wordIndex++
                abbrIndex++
            } else {
                return false
            }
        }
    }
    return wordIndex == word.length && abbrIndex == abbr.length
}

private fun main() {

}
