package leetcode.leetcode_1023_camelcase_matching

/**
 * leetcode - https://leetcode.com/problems/camelcase-matching/
 *
 * Data Structure - [String]
 * Algorithm - Two Pointers & Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google
 */
private fun camelMatch(queries: Array<String>, pattern: String): List<Boolean> {
    val result = mutableListOf<Boolean>()
    fun matches(query: String): Boolean {
        var patternIndex = 0
        var queryIndex = 0
        while (patternIndex <= pattern.lastIndex && queryIndex <= query.lastIndex) {
            if (pattern[patternIndex] == query[queryIndex]) {
                patternIndex++
            } else if (query[queryIndex] in 'A'..'Z') {
                return false
            }
            queryIndex++
        }
        if (queryIndex == query.length) {
            return patternIndex == pattern.length
        }
        if (patternIndex == pattern.length) {
            while (queryIndex <= query.lastIndex) {
                if (query[queryIndex] in 'A'..'Z') {
                    return false
                }
                queryIndex++
            }
        }
        return true
    }

    for (query in queries) {
        result.add(matches(query))
    }
    return result
}

private fun main() {

}
