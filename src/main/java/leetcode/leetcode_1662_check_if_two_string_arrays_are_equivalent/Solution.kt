package leetcode.leetcode_1662_check_if_two_string_arrays_are_equivalent

/**
 * leetcode - https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 *
 * Using two pointers
 *
 * Stats
 * Runtime: 140 ms, faster than 97.92%
 * Memory Usage: 34.6 MB, less than 97.92%
 */
private fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
    var stringIndex1 = 0
    var stringIndex2 = 0
    var charIndex1 = 0
    var charIndex2 = 0
    while (stringIndex1 < word1.size && stringIndex2 < word2.size) {
        if (word1[stringIndex1][charIndex1] != word2[stringIndex2][charIndex2]) {
            return false
        }
        charIndex1++
        if (charIndex1 == word1[stringIndex1].length) {
            stringIndex1++
            charIndex1 = 0
        }
        charIndex2++
        if (charIndex2 == word2[stringIndex2].length) {
            stringIndex2++
            charIndex2 = 0
        }
    }
    return !(stringIndex1 != word1.size || stringIndex2 != word2.size)
}

private fun main() {

}
