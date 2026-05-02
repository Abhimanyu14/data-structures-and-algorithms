package leetcode.leetcode_1119_remove_vowels_from_a_string

/**
 * leetcode - https://leetcode.com/problems/remove-vowels-from-a-string/description/
 *
 * Data Structure - [StringBuilder]
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Amazon
 */
private fun removeVowels(s: String): String {
    val stringBuilder = StringBuilder()
    for (char in s) {
        if (char != 'a' && char != 'e' && char != 'i' && char != 'o' && char != 'u') {
            stringBuilder.append(char)
        }
    }
    return stringBuilder.toString()
}

private fun main() {

}
