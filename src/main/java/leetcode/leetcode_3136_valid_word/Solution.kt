package leetcode.leetcode_3136_valid_word

/**
 * leetcode - https://leetcode.com/problems/valid-word/
 *
 * Using iteration and set
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 25 ms, faster than 30.77%
 * Memory Usage: 37.9 MB, less than 33.33%
 *
 * Time -
 * Space -
 */
private fun isValid(word: String): Boolean {
    if (word.length < 3) {
        return false
    }
    var hasVowel = false
    var hasConsonant = false
    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

    for (char in word) {
        if (char !in '0'..'9' && char !in 'a'..'z' && char !in 'A'..'Z') {
            return false
        }
        if (char in vowels) {
            hasVowel = true
        } else {
            if (char in 'a'..'z' || char in 'A'..'Z') {
                hasConsonant = true
            }
        }
    }
    return hasVowel && hasConsonant
}

private fun main() {

}
