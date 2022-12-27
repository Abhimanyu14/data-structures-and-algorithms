package leetcode.leet_100_to_199.leet_150_evaluate_reverse_polish_notation

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
    tokens.forEach {
        if (it == "+" || it == "-" || it == "*" || it == "/") {
            val second = stack.removeLast()
            val first = stack.removeLast()
            when (it) {
                "+" -> {
                    stack.addLast(first + second)
                }

                "-" -> {
                    stack.addLast(first - second)
                }

                "*" -> {
                    stack.addLast(first * second)
                }

                "/" -> {
                    stack.addLast(first / second)
                }
            }

        } else {
            stack.addLast(it.toInt())
        }
    }
    return stack.removeLast()
}

private fun main() {

}
