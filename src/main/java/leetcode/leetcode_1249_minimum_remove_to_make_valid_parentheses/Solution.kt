package leetcode.leetcode_1249_minimum_remove_to_make_valid_parentheses

/**
 * leetcode - https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Data Structure - [ArrayDeque] (Stack), [Set], [StringBuilder]
 * Algorithm - Stacking, Hashing and Building string
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 41 ms, faster than 42.73%
 * Memory Usage: 49.51 MB, less than 15.45%
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun minRemoveToMakeValid(s: String): String {
    val result = StringBuilder()
    val skipIndices = mutableSetOf<Int>()
    val stack = ArrayDeque<Int>()
    for (i in s.indices) {
        if (s[i] == ')') {
            if (stack.isEmpty()) {
                skipIndices.add(i)
            } else {
                stack.removeLast()
            }
        } else if (s[i] == '(') {
            stack.addLast(i)
        }
    }
    while (stack.isNotEmpty()) {
        skipIndices.add(stack.removeLast())
    }
    for (i in s.indices) {
        if (!skipIndices.contains(i)) {
            result.append(s[i])
        }
    }
    return result.toString()
}

private fun main() {

}
