package leetcode.leetcode_1200_to_1299.leetcode_1249_minimum_remove_to_make_valid_parentheses

/**
 * leetcode - https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Using set, stack, and string builder
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 249 ms, faster than 70.41%
 * Memory Usage: 39.9 MB, less than 53.06%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun minRemoveToMakeValid(s: String): String {
    val skips = mutableSetOf<Int>()
    val stack = ArrayDeque<Int>()
    s.forEachIndexed { index, char ->
        if (char == ')') {
            if (stack.isEmpty()) {
                skips.add(index)
            } else {
                stack.removeLast()
            }
        } else if (char == '(') {
            stack.addLast(index)
        }
    }
    while (stack.isNotEmpty()) {
        skips.add(stack.removeLast())
    }
    val result = StringBuilder()
    s.forEachIndexed { index, char ->
        if (!skips.contains(index)) {
            result.append(char)
        }
    }
    return result.toString()
}

private fun main() {

}
