package leetcode.leetcode_1111_maximum_nesting_depth_of_two_valid_parentheses_strings

/**
 * leetcode - https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [IntArray]
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Google
 */
private fun maxDepthAfterSplit(seq: String): IntArray {
    val result = IntArray(seq.length)
    var current = 0
    var openCount = 0
    for (i in seq.indices) {
        if (seq[i] == '(') {
            current++
            if (current % 2 == 0) {
                result[i] = 1
                openCount++
            }
        } else {
            if (openCount > 0 && current % 2 == 0) {
                result[i] = 1
                openCount--
            }
            current--
        }
    }
    return result
}

private fun main() {

}
