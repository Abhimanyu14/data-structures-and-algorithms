package leetcode.leetcode_900_to_999.leetcode_921_minimum_add_to_make_parentheses_valid

/**
 * leetcode - https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 *
 * Using counters
 *
 * Stats
 * Runtime: 148 ms, faster than 96.00%
 * Memory Usage: 33.6 MB, less than 100.00%
 */
private fun minAddToMakeValid(s: String): Int {
    var count = 0
    var result = 0
    s.forEach {
        if (it == '(') {
            count++
        } else {
            count--
            if (count < 0) {
                count = 0
                result++
            }
        }
    }
    return count + result
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
