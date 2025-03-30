package leetcode.leetcode_1249_minimum_remove_to_make_valid_parentheses

/**
 * leetcode - https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [ArrayDeque] (Stack), [Set], [StringBuilder]
 * Algorithm -
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
    val stack = ArrayDeque<Int>()
    val skips = mutableSetOf<Int>()
    for (i in s.indices) {
        if (s[i] == '(') {
            stack.addLast(i)
        } else if (s[i] == ')') {
            if (stack.isEmpty()) {
                skips.add(i)
            } else {
                stack.removeLast()
            }
        }
    }
    while (stack.isNotEmpty()) {
        skips.add(stack.removeLast())
    }
    for (i in s.indices) {
        if (!skips.contains(i)) {
            result.append(s[i])
        }
    }
    return result.toString()
}

private fun main() {

}
