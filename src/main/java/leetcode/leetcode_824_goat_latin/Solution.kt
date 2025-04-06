package leetcode.leetcode_824_goat_latin

/**
 * leetcode - https://leetcode.com/problems/goat-latin/
 *
 * Data Structure - [StringBuilder], [Set]
 * Algorithm - Iteration
 *
 * String properties - [lastIndex]
 *
 * String methods - [repeat]
 * StringBuilder methods - [append]
 * Set methods - [contains]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 22 ms, faster than 70.15%
 * Memory Usage: 46.63 MB, less than 17.91%
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun toGoatLatin(sentence: String): String {
    val result = StringBuilder()
    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    var wordStartsWithVowel: Boolean
    var wordStartingLetter: Char
    var index = 1
    var i = 0
    while (i <= sentence.lastIndex) {
        if (index > 1) {
            result.append(' ')
        }
        wordStartsWithVowel = vowels.contains(sentence[i])
        wordStartingLetter = sentence[i]
        if (wordStartsWithVowel) {
            result.append(wordStartingLetter)
        }
        i++
        while (i <= sentence.lastIndex && sentence[i] != ' ') {
            result.append(sentence[i])
            i++
        }
        if (!wordStartsWithVowel) {
            result.append(wordStartingLetter)
        }
        result.append("ma")
        result.append("a".repeat(index))
        index++
        i++
    }
    return result.toString()
}

/**
 * leetcode - https://leetcode.com/problems/goat-latin/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * methods - mapIndexed, repeat, substring and joinString.
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 201 ms, faster than 12.50%
 * Memory Usage: 38.2 MB, less than 87.50%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun toGoatLatinUsingFunctionalProgramming(sentence: String): String {
    val vowels = setOf('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u')
    return sentence.split(" ").mapIndexed { index, str ->
        if (str[0] in vowels) {
            "${str}ma${"a".repeat(index + 1)}"
        } else {
            "${str.substring(1)}${str[0]}ma${"a".repeat(index + 1)}"
        }
    }.joinToString(" ")
}

private fun main() {

}
