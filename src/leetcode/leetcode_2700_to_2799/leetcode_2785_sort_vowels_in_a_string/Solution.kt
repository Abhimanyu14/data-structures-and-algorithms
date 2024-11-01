package leetcode.leetcode_2700_to_2799.leetcode_2785_sort_vowels_in_a_string

/**
 * leetcode - https://leetcode.com/problems/sort-vowels-in-a-string/
 *
 * Using string builder and iteration
 *
 * Stats
 * Runtime: 502 ms, faster than 75.00%
 * Memory Usage: 48.5 MB, less than 37.50%
 */
private fun Char.isVowel(): Boolean {
    return this == 'a' || this == 'e' || this == 'i' || this == 'o' || this == 'u'
            || this == 'A' || this == 'E' || this == 'I' || this == 'O' || this == 'U'
}

private fun sortVowels(s: String): String {
    val vowelsIndices = mutableListOf<Int>()
    val vowels = mutableListOf<Char>()
    s.forEachIndexed { index, char ->
        if (char.isVowel()) {
            vowelsIndices.add(index)
            vowels.add(char)
        }
    }
    vowels.sort()
    return ""
}

private fun main() {

}
