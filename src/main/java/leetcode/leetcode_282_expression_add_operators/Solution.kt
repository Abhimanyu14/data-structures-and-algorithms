package leetcode.leetcode_282_expression_add_operators

/**
 * leetcode - https://leetcode.com/problems/expression-add-operators/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Backtracking - Recursion
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google, Meta
 */
private fun addOperators(num: String, target: Int): List<String> {
    val result = mutableListOf<String>()
    fun equalsTarget(expression: String) {
        if (!expression.last().isDigit()) {
            return
        }

        val stack = ArrayDeque<Long>()

        var index = 0
        var prevOperator = '+'
        while (index <= expression.lastIndex) {
            var current = 0L
            if (index < expression.lastIndex && expression[index] == '0' && expression[index + 1].isDigit()) {
                return
            }
            while (index <= expression.lastIndex && expression[index].isDigit()) {
                current = (current * 10) + expression[index].digitToInt()
                index++
            }
            when (prevOperator) {
                '-' -> {
                    stack.addLast(current * -1)
                }

                '*' -> {
                    stack.addLast(stack.removeLast() * current)
                }

                '+' -> {
                    stack.addLast(current)
                }
            }
            if (index <= expression.lastIndex) {
                prevOperator = expression[index]
                index++
            }
        }

        var sum = 0L
        while (stack.isNotEmpty()) {
            sum += stack.removeLast()
        }
        if (sum == target.toLong()) {
            result.add(expression)
        }
    }

    val currentExpression = StringBuilder()
    fun backtrack(index: Int) {
        if (index == num.length) {
            equalsTarget(currentExpression.toString())
            return
        }

        currentExpression.append(num[index])
        backtrack(index + 1)

        currentExpression.append('+')
        backtrack(index + 1)
        currentExpression.deleteCharAt(currentExpression.lastIndex)

        currentExpression.append('-')
        backtrack(index + 1)
        currentExpression.deleteCharAt(currentExpression.lastIndex)

        currentExpression.append('*')
        backtrack(index + 1)
        currentExpression.deleteCharAt(currentExpression.lastIndex)

        currentExpression.deleteCharAt(currentExpression.lastIndex)
    }
    backtrack(0)
    return result
}

private fun main() {

}
