package leetcode.leetcode_214_shortest_palindrome

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/shortest-palindrome/?envType=daily-question&envId=2024-09-20
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 */
private class Solution {
    fun shortestPalindrome(s: String?): String? {
        // Return early if the string is null or empty
        if (s == null || s.length == 0) {
            return s
        }

        // Preprocess the string to handle palindromes uniformly
        val modifiedString = preprocessString(s)
        val palindromeRadiusArray = IntArray(modifiedString.length)
        var center = 0
        var rightBoundary = 0
        var maxPalindromeLength = 0

        // Iterate through each character in the modified string
        for (i in 1..<modifiedString.length - 1) {
            val mirrorIndex = 2 * center - i

            // Use previously computed values to avoid redundant calculations
            if (rightBoundary > i) {
                palindromeRadiusArray[i] = min(
                    (rightBoundary - i).toDouble(),
                    palindromeRadiusArray[mirrorIndex].toDouble()
                ).toInt()
            }

            // Expand around the current center while characters match
            while (modifiedString[i + 1 + palindromeRadiusArray[i]] ==
                modifiedString[i - 1 - palindromeRadiusArray[i]]
            ) {
                palindromeRadiusArray[i]++
            }

            // Update the center and right boundary if the palindrome extends beyond the current boundary
            if (i + palindromeRadiusArray[i] > rightBoundary) {
                center = i
                rightBoundary = i + palindromeRadiusArray[i]
            }

            // Update the maximum length of palindrome starting at the beginning
            if (i - palindromeRadiusArray[i] == 1) {
                maxPalindromeLength = max(
                    maxPalindromeLength.toDouble(),
                    palindromeRadiusArray[i].toDouble()
                ).toInt()
            }
        }

        // Construct the shortest palindrome by reversing the suffix and prepending it to the original string
        val suffix = StringBuilder(
            s.substring(maxPalindromeLength)
        ).reverse()
        return suffix.append(s).toString()
    }

    private fun preprocessString(s: String): String {
        // Add boundaries and separators to handle palindromes uniformly
        val sb = StringBuilder("^")
        for (c in s.toCharArray()) {
            sb.append("#").append(c)
        }
        return sb.append("#$").toString()
    }
}

private fun main() {

}
