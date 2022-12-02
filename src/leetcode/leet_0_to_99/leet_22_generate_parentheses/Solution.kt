package leetcode.leet_0_to_99.leet_22_generate_parentheses

/**
 * Using recursion - brute force
 *
 * Stats
 * Runtime: 295 ms, faster than 65.88%
 * Memory Usage: 37.3 MB, less than 78.34%
 */
private fun generateParenthesisBruteForce(n: Int): List<String> {
    val combinations = mutableListOf<String>()
    generateAll(CharArray(2 * n), 0, combinations)
    return combinations
}

private fun generateAll(current: CharArray, pos: Int, result: MutableList<String>) {
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

private fun valid(current: CharArray): Boolean {
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

/**
 * Using recursion - brute force
 *
 * Stats
 * Runtime: 173 ms, faster than 99.41%
 * Memory Usage: 37.4 MB, less than 76.56%
 */
private fun generateParenthesis(n: Int): List<String> {
    val combinations = mutableListOf<String>()
    generateAll(combinations, StringBuilder(), 0, 0, n)
    return combinations
}

private fun generateAll(result: MutableList<String>, current: StringBuilder, open: Int, close: Int, max: Int) {
    if (current.length == max * 2) {
        result.add(current.toString())
        return
    }
    if (open < max) {
        current.append('(')
        generateAll(result, current, open + 1, close, max)
        current.deleteCharAt(current.length - 1)
    }
    if (close < open) {
        current.append(')')
        generateAll(result, current, open, close + 1, max)
        current.deleteCharAt(current.length - 1)
    }
}

/**
 * TODO-Abhi: Using closure number
 *
 *
 */

private fun main() {
    val solution = ::generateParenthesis
    println(solution(1))
    println(solution(2))
}
