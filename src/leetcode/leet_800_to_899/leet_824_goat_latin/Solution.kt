package leetcode.leet_800_to_899.leet_824_goat_latin

/**
 * leetcode - https://leetcode.com/problems/goat-latin/
 *
 * Using functional programming
 * methods - mapIndexed, repeat, substring and joinString.
 *
 * Stats
 * Runtime: 201 ms, faster than 12.50%
 * Memory Usage: 38.2 MB, less than 87.50%
 */
private fun toGoatLatin(sentence: String): String {
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
