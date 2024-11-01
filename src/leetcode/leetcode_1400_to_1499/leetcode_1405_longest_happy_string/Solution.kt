package leetcode.leetcode_1400_to_1499.leetcode_1405_longest_happy_string

/**
 * leetcode - https://leetcode.com/problems/longest-happy-string/
 *
 * Using brute force
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 112 ms, faster than 100.00%
 * Memory Usage: 33.6 MB, less than 100.00%
 *
 * Time -
 * Space -
 */
private fun getNextChar(a: Int, b: Int, c: Int, prevChar: Char? = null, prevCharCount: Int = 0): Char? {
    // println("$a $b $c $prevChar $prevCharCount")
    val excludeA = prevChar == 'a' && prevCharCount == 2
    val excludeB = prevChar == 'b' && prevCharCount == 2
    val excludeC = prevChar == 'c' && prevCharCount == 2
    return if (excludeA) {
        if (b > 0 && b >= c) {
            'b'
        } else if (c > 0) {
            'c'
        } else {
            null
        }
    } else if (excludeB) {
        if (a > 0 && a >= c) {
            'a'
        } else if (c > 0) {
            'c'
        } else {
            null
        }
    } else if (excludeC) {
        if (a > 0 && a >= b) {
            'a'
        } else if (b > 0) {
            'b'
        } else {
            null
        }
    } else {
        if (a > 0 && a >= b && a >= c) {
            'a'
        } else if (b > 0 && b >= a && b >= c) {
            'b'
        } else if (c > 0) {
            'c'
        } else {
            null
        }
    }
}

private fun longestDiverseString(a: Int, b: Int, c: Int): String {
    val count = intArrayOf(a, b, c)
    val stringBuilder = StringBuilder()
    var prevCharCount = 0
    var prevChar: Char? = null
    var nextChar: Char? = getNextChar(count[0], count[1], count[2])
    while (nextChar != null) {
        count[nextChar - 'a']--
        stringBuilder.append(nextChar)
        if (prevChar == nextChar) {
            prevCharCount++
        } else {
            prevChar = nextChar
            prevCharCount = 1
        }
        nextChar = getNextChar(count[0], count[1], count[2], prevChar, prevCharCount)
    }
    return stringBuilder.toString()
}

private fun main() {

}
