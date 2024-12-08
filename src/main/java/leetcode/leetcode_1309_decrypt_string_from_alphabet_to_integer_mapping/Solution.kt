package leetcode.leetcode_1309_decrypt_string_from_alphabet_to_integer_mapping

/**
 * leetcode - https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 *
 * Data Structure - StringBuilder
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 9 ms, faster than 100.00%
 * Memory Usage: 36.3 MB, less than 88.89%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun freqAlphabets(s: String): String {
    val result = StringBuilder()
    var index = s.lastIndex
    while (index >= 0) {
        if (s[index] == '#') {
            result.insert(0, 'a' + (((s[index - 2] - '0') * 10) + (s[index - 1] - '0') - 1))
            index -= 3
        } else {
            result.insert(0, 'a' + (s[index] - '0') - 1)
            index--
        }
    }
    return result.toString()
}

private fun main() {

}
