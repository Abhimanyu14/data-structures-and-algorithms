package leetcode.leetcode_921_minimum_add_to_make_parentheses_valid

/**
 * leetcode - https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 *
 * Data Structure - Pointer
 * Algorithm - Counting
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun minAddToMakeValid(s: String): Int {
    var result = 0
    var current = 0
    for (char in s) {
        if (char == '(') {
            current++
        } else {
            if (current > 0) {
                current--
            } else {
                result++
            }
        }
    }
    return result + current
}

/**
 * leetcode - https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 *
 * Using stack - array deque
 *
 * Stats
 * Runtime: 166 ms, faster than 80.00%
 * Memory Usage: 35.2 MB, less than 12.00%
 */
private fun minAddToMakeValidUsingStack(s: String): Int {
    val stack = ArrayDeque<Char>()
    var count = 0
    s.forEach {
        if (it == '(') {
            stack.addLast(it)
        } else {
            if (stack.isNotEmpty() && stack.last() == '(') {
                stack.removeLast()
            } else {
                count++
            }
        }
    }
    return count + stack.size
}

private fun main() {

}
