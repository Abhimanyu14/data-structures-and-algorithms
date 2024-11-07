package leetcode.leetcode_3163_string_compression_iii

/**
 * leetcode - https://leetcode.com/problems/string-compression-iii/?envType=daily-question&envId=2024-11-04
 *
 * Using string builder and iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 21 ms, faster than 100.00%
 * Memory Usage: 45 MB, less than 57.14%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun compressedString(word: String): String {
    val result = StringBuilder()
    var prevChar = word[0]
    var prevCharCount = 1
    for (i in 1..<word.length) {
        if (word[i] == prevChar) {
            prevCharCount++
            if (prevCharCount == 10) {
                result.append('9')
                result.append(prevChar)
                prevCharCount = 1
            }
        } else {
            result.append(prevCharCount)
            result.append(prevChar)
            prevChar = word[i]
            prevCharCount = 1
        }
    }
    result.append(prevCharCount)
    result.append(prevChar)
    return result.toString()
}

private fun main() {

}
