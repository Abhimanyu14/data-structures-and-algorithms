package leetcode.leetcode_22_generate_parentheses

/**
 * leetcode - https://leetcode.com/problems/generate-parentheses/
 *
 * TODO-Abhi: Using Catalan number
 *
 * Stats
 */

/**
 * leetcode - https://leetcode.com/problems/generate-parentheses/
 *
 * Using Stack
 *
 * Stats
 * Runtime: 229 ms, faster than 5.20%
 * Memory Usage: 40.6 MB, less than 5.20%
 */
private fun generateParenthesis(n: Int): List<String> {
    val combinations = mutableListOf<String>()
    fun generateAll(stack: ArrayDeque<Char>, openCount: Int, closeCount: Int) {
        if (stack.size == n * 2) {
            combinations.add(stack.joinToString(""))
            return
        }
        if (openCount < n) {
            stack.addLast('(')
            generateAll(stack, openCount + 1, closeCount)
            stack.removeLast()
        }
        if (closeCount < openCount) {
            stack.addLast(')')
            generateAll(stack, openCount, closeCount + 1)
            stack.removeLast()
        }
    }
    generateAll(ArrayDeque(), 0, 0)
    return combinations
}

/**
 * leetcode - https://leetcode.com/problems/generate-parentheses/
 *
 * Using recursion - brute force, backtracking, without string builder
 *
 * Stats
 * Runtime: 160 ms, faster than 74.00%
 * Memory Usage: 36.9 MB, less than 60.00%
 */
private fun generateParenthesisWithoutStringBuilder(n: Int): List<String> {
    val combinations = mutableListOf<String>()
    fun generateAll(current: String, openCount: Int, closeCount: Int) {
        if (current.length == n * 2) {
            combinations.add(current)
            return
        }
        if (openCount < n) {
            generateAll("$current(", openCount + 1, closeCount)
        }
        if (closeCount < openCount) {
            generateAll("$current)", openCount, closeCount + 1)
        }
    }
    generateAll("", 0, 0)
    return combinations
}

/**
 * leetcode - https://leetcode.com/problems/generate-parentheses/
 *
 * Using recursion - brute force, backtracking, string builder
 * StringBuilder - append, deleteCharAt
 *
 * Stats
 * Runtime: 156 ms, faster than 81.20%
 * Memory Usage: 37.1 MB, less than 47.60%
 */
private fun generateParenthesisWithStringBuilder(n: Int): List<String> {
    val combinations = mutableListOf<String>()
    fun generateAll(current: StringBuilder, openCount: Int, closeCount: Int, max: Int) {
        if (current.length == max * 2) {
            combinations.add(current.toString())
            return
        }
        if (openCount < max) {
            current.append('(')
            generateAll(current, openCount + 1, closeCount, max)
            current.deleteCharAt(current.lastIndex)
        }
        if (closeCount < openCount) {
            current.append(')')
            generateAll(current, openCount, closeCount + 1, max)
            current.deleteCharAt(current.lastIndex)
        }
    }
    generateAll(StringBuilder(), 0, 0, n)
    return combinations
}

/**
 * leetcode - https://leetcode.com/problems/generate-parentheses/
 *
 * Using recursion - brute force
 *
 * Stats
 * Runtime: 295 ms, faster than 65.88%
 * Memory Usage: 37.3 MB, less than 78.34%
 */
private fun generateParenthesisBruteForce(n: Int): List<String> {
    val combinations = mutableListOf<String>()
    fun valid(current: CharArray): Boolean {
        var balance = 0
        for (c in current) {
            if (c == '(') {
                balance++
            } else {
                balance--
            }
            if (balance < 0) {
                return false
            }
        }
        return balance == 0
    }

    fun generateAll(current: CharArray, pos: Int, result: MutableList<String>) {
        if (pos == current.size) {
            if (valid(current)) {
                result.add(String(current))
            }
        } else {
            current[pos] = '('
            generateAll(current, pos + 1, result)
            current[pos] = ')'
            generateAll(current, pos + 1, result)
        }
    }
    generateAll(CharArray(2 * n), 0, combinations)
    return combinations
}

private fun main() {
    val solution = ::generateParenthesis
    println(solution(1))
    println(solution(2))
}
