package leetcode.leetcode_2200_to_2299.leetcode_2272_substring_with_largest_variance

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/substring-with-largest-variance/
 *
 * Using Kadane's Algorithm
 *
 * Stats
 * Runtime: 335 ms, faster than 100.00%
 * Memory Usage: 36.4 MB, less than 100.00%
 */
private fun largestVariance(s: String): Int {
    val counter = IntArray(26)
    s.forEach {
        counter[it - 'a']++
    }
    var globalMax = 0

    for (i in 0..25) {
        for (j in 0..25) {
            // major and minor cannot be the same, and both must appear in s.
            if (i == j || counter[i] == 0 || counter[j] == 0) {
                continue
            }

            // Find the maximum variance of major - minor.
            val major = 'a' + i
            val minor = 'a' + j
            var majorCount = 0
            var minorCount = 0

            // The remaining minor in the rest of s.
            var remainingMinor = counter[j]
            s.forEach { ch ->
                if (ch == major) {
                    majorCount++
                }
                if (ch == minor) {
                    minorCount++
                    remainingMinor--
                }

                // Only update the variance if there is at least one minor.
                if (minorCount > 0) {
                    globalMax = max(globalMax, majorCount - minorCount)
                }

                // We can discard the previous string if there is at least one remaining minor.
                if (majorCount < minorCount && remainingMinor > 0) {
                    majorCount = 0
                    minorCount = 0
                }
            }
        }
    }

    return globalMax
}

/**
 * leetcode - https://leetcode.com/problems/substring-with-largest-variance/
 *
 * Using brute force
 *
 * Stats
 * Output Limit Exceeded
 */
private fun largestVarianceBruteForce(s: String): Int {
    val substrings = getSubStrings(s)
    var result = 0
    substrings.forEach {
        val charCountMap = getCharCounter(it)
        val charCountList = charCountMap.values
        val diff = (charCountList.max() ?: 0) - (charCountList.min() ?: 0)
        if (result < diff) {
            result = diff
        }
    }
    return result
}

private fun getSubStrings(s: String): List<String> {
    val result = mutableListOf<String>()
    for (i in 1..s.length) {
        for (j in 0..(s.lastIndex - i + 1)) {
            result.add(s.substring(j, j + i))
        }
    }
    return result
}

private fun getCharCounter(s: String): Map<Char, Int> {
    val map = mutableMapOf<Char, Int>()
    s.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    return map
}

private fun main() {
    println(largestVariance("aababbb"))
    println()
    println(largestVariance("abcde"))
}
