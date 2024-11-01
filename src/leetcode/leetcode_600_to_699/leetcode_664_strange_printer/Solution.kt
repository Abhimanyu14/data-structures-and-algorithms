package leetcode.leetcode_600_to_699.leetcode_664_strange_printer

import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/strange-printer/?envType=daily-question&envId=2024-08-21
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun strangePrinter(s: String): Int {
    fun removeDuplicates(s: String): String {
        val uniqueChars = StringBuilder()
        var i = 0
        while (i < s.length) {
            val currentChar = s[i]
            uniqueChars.append(currentChar)
            // Skip all consecutive occurrences of the current character
            while (i < s.length && s[i] == currentChar) {
                i++
            }
        }
        return uniqueChars.toString()
    }

    // Preprocess the string to remove consecutive duplicate characters
    var sTemp = s
    sTemp = removeDuplicates(sTemp)

    val n = sTemp.length

    // dp[i][j] represents the minimum number of turns to print s[i] to s[j]
    val minTurns = Array(n) { IntArray(n) }

    // Initialize base case
    for (i in 0..<n) {
        // It takes 1 turn to print a single character
        minTurns[i][i] = 1
    }

    // Fill the dp table
    for (length in 2..n) {
        var start = 0
        while (start + length - 1 < n) {
            val end = start + length - 1

            // Initialize with worst case: print each character separately
            minTurns[start][end] = length

            // Try all possible splits and find the minimum
            for (split in 0..<length - 1) {
                var totalTurns =
                    minTurns[start][start + split] +
                            minTurns[start + split + 1][end]

                // If the characters at the split and end match, we can save one turn
                if (sTemp[start + split] == sTemp[end]) {
                    totalTurns--
                }

                minTurns[start][end] = min(
                    minTurns[start][end].toDouble(),
                    totalTurns.toDouble()
                ).toInt()
            }
            start++
        }
    }

    // Return the minimum turns needed to print the entire string
    return minTurns[0][n - 1]
}

private fun main() {

}
