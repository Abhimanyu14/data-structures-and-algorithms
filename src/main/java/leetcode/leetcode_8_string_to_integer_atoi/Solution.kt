package leetcode.leetcode_8_string_to_integer_atoi

/**
 * leetcode - https://leetcode.com/problems/string-to-integer-atoi/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 145 ms, faster than 99.10%
 * Memory Usage: 35.2 MB, less than 60.81%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun myAtoi(s: String): Int {
    var sign = 1
    var result = 0
    var index = 0
    while (index <= s.lastIndex && s[index] == ' ') {
        index++
    }
    if (index <= s.lastIndex && (s[index] == '+' || s[index] == '-')) {
        if (s[index] == '-') {
            sign = -1
        }
        index++
    }
    while (index <= s.lastIndex && s[index].isDigit()) {
        if (sign == 1) {
            if ((result.toLong() * 10 + s[index].digitToInt()) <= Int.MAX_VALUE) {
                result = (result * 10) + s[index].digitToInt()
            } else {
                result = Int.MAX_VALUE
                break
            }
        } else {
            if ((sign * result.toLong() * 10 + s[index].digitToInt()) >= Int.MIN_VALUE) {
                result = (result * 10) + s[index].digitToInt()
            } else {
                result = Int.MIN_VALUE
                break
            }
        }
        index++
    }
    return result * sign
}

private fun myAtoi1(s: String): Int {
    var isPositive = true
    var i = 0

    // Leading space
    while (i < s.length && s[i] == ' ') {
        i++
    }

    // Sign
    if (i < s.length) {
        if (s[i] == '+') {
            isPositive = true
            i++
        } else if (s[i] == '-') {
            isPositive = false
            i++
        } else if (s[i].isDigit()) {
            // No action
        } else {
            return 0
        }
    }

    // Leading zeroes
    while (i < s.length && s[i] == '0') {
        i++
    }

    var result = 0
    while (i < s.length && s[i].isDigit()) {
        if (result < Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && (s[i] - '0') <= 7)) {
            result = (result * 10) + (s[i] - '0')
        } else {
            return if (isPositive) {
                Int.MAX_VALUE
            } else {
                Int.MIN_VALUE
            }
        }
        i++
    }

    return if (isPositive) {
        result
    } else {
        result * -1
    }
}

private fun main() {
    println(myAtoi("42")) // 42
    println(myAtoi("+42")) // 42
    println(myAtoi("-0000123")) // 42
    println(myAtoi("   -42")) // -42
    println(myAtoi("   -   42")) // 0
    println(myAtoi("4193 with words")) // 4193
    println(myAtoi("4193 with 4 words")) // 4193
    println(myAtoi("9223372036854775808"))
    println(myAtoi("21474836471"))
}
