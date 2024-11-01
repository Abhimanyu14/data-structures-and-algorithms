package leetcode.leetcode_100_to_199.leetcode_150_evaluate_reverse_polish_notation

/**
 * leetcode - https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Using stack
 *
 * Stats
 * Runtime: 185 ms, faster than 97.89%
 * Memory Usage: 35.6 MB, less than 94.74%
 */
private fun evalRPN(tokens: Array<String>): Int {
    val stack = ArrayDeque<Int>()
    val operators = setOf("+", "-", "*", "/")
    tokens.forEach {
        if (operators.contains(it)) {
            val second = stack.removeLast()
            val first = stack.removeLast()
            stack.addLast(
                when (it) {
                    "+" -> first + second
                    "-" -> first - second
                    "*" -> first * second
                    "/" -> first / second
                    else -> -1
                }
            )
        } else {
            stack.addLast(it.toInt())
        }
    }
    return stack.removeLast()
}

private fun main() {

}
