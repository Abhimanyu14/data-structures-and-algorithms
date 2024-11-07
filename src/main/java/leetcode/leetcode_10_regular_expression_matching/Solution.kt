package leetcode.leetcode_10_regular_expression_matching

/**
 * leetcode - https://leetcode.com/problems/regular-expression-matching/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 416 ms, faster than 30.52%
 * Memory Usage: 77.9 MB, less than 9.74%
 */
private fun isMatchUsingRecursion(text: String, pattern: String): Boolean {
    if (pattern.isEmpty()) {
        return text.isEmpty()
    }
    val firstCharMatch = text.isNotEmpty() && (pattern[0] == text[0] || pattern[0] == '.')
    return if (pattern.length >= 2 && pattern[1] == '*') {
        isMatch(text, pattern.substring(2)) || firstCharMatch && isMatch(text.substring(1), pattern)
    } else {
        firstCharMatch && isMatch(text.substring(1), pattern.substring(1))
    }
}

/**
 * leetcode - https://leetcode.com/problems/regular-expression-matching/
 *
 * TODO-Abhi: Revisit
 * Using dynamic programming
 *
 * Stats
 *
 */
enum class Result {
    TRUE, FALSE
}

private fun isMatch(text: String, pattern: String): Boolean {
    val memo: Array<Array<Result?>> = Array(text.length + 1) {
        arrayOfNulls(pattern.length + 1)
    }
    return dp(0, 0, text, pattern, memo)
}

fun dp(i: Int, j: Int, text: String, pattern: String, memo: Array<Array<Result?>>): Boolean {
    if (memo[i][j] != null) {
        return memo[i][j] == Result.TRUE
    }
    val ans: Boolean = if (j == pattern.length) {
        i == text.length
    } else {
        val firstCharMatch = i < text.length && (pattern[j] == text[i] || pattern[j] == '.')
        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
            dp(i, j + 2, text, pattern, memo) || firstCharMatch && dp(i + 1, j, text, pattern, memo)
        } else {
            firstCharMatch && dp(i + 1, j + 1, text, pattern, memo)
        }
    }
    memo[i][j] = if (ans) {
        Result.TRUE
    } else {
        Result.FALSE
    }
    return ans
}

private fun main() {
    println(isMatch("aa", "a")) // false
    println(isMatch("aa", "a*")) // true
    println(isMatch("ab", ".*")) // true
    println(isMatch("a", "ab*")) // true
    println(isMatch("bbbba", ".*a*a")) // true
}
