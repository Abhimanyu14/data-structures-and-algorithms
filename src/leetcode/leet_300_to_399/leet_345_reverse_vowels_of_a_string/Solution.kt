package leetcode.leet_300_to_399.leet_345_reverse_vowels_of_a_string

/**
 * leetcode - https://leetcode.com/problems/reverse-vowels-of-a-string/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 235 ms, faster than 52.74%
 * Memory Usage: 40 MB, less than 50.61%
 */
private fun reverseVowels(s: String): String {
    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    var start = 0
    var end = s.lastIndex
    val result = StringBuilder()
    while(start < s.length) {
        if (!vowels.contains(s[start])) {
            result.append(s[start])
        } else {
            while (!vowels.contains(s[end])) {
                end--
            }
            result.append(s[end])
            end--
        }
        start++
    }
    return result.toString()
}

private fun main() {

}
