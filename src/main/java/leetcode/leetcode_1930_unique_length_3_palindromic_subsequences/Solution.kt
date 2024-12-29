package leetcode.leetcode_1930_unique_length_3_palindromic_subsequences


/**
 * leetcode - https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 379 ms, faster than 94.44%
 * Memory Usage: 38.3 MB, less than 100.00%
 */
private fun countPalindromicSubsequence(s: String): Int {
    var result = 0
    val firstIndices = IntArray(26) { -1 }
    val lastIndices = IntArray(26)
    s.forEachIndexed { index, char ->
        val letterIndex = char - 'a'
        if (firstIndices[letterIndex] == -1) {
            firstIndices[letterIndex] = index
        }
        lastIndices[letterIndex] = index
    }
    for (i in 0..25) {
        if (firstIndices[i] == -1) {
            continue
        }
        val between = mutableSetOf<Char>()
        for (j in firstIndices[i] + 1..<lastIndices[i]) {
            between.add(s[j])
        }
        result += between.size
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 383 ms, faster than 94.44%
 * Memory Usage: 39.8 MB, less than 94.44%
 */
private fun countPalindromicSubsequenceUsingCount(s: String): Int {
    var result = 0
    val letters = s.toSet()
    letters.forEach { letter ->
        var first = -1
        var last = 0
        s.forEachIndexed { index, char ->
            if (char == letter) {
                if (first == -1) {
                    first = index
                }
                last = index
            }
        }
        val between = mutableSetOf<Char>()
        for (k in first + 1..<last) {
            between.add(s[k])
        }
        result += between.size
    }
    return result
}

private fun main() {

}
