package leetcode.leetcode_65_valid_number

/**
 * leetcode - https://leetcode.com/problems/valid-number/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Conditions and Iterations
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 223 ms, faster than 7.41%
 * Memory Usage: 37.7 MB, less than 7.41%
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun isNumber(s: String): Boolean {
    val digits = hashSetOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

    var sign = false
    var decimal = false
    var initialNumber = false
    var exponent = false
    var finalInt = false

    s.forEach {
        if (it == '+' || it == '-') {
            if (sign || (initialNumber && !exponent) || (decimal && !exponent) || finalInt) {
                return false
            } else {
                sign = true
            }
        } else if (digits.contains(it)) {
            if (exponent) {
                finalInt = true
            } else {
                initialNumber = true
            }
        } else if (it == '.') {
            if (decimal || exponent) {
                return false
            } else {
                decimal = true
            }
        } else if (it == 'e' || it == 'E') {
            if (!initialNumber || exponent) {
                return false
            } else {
                sign = false
                exponent = true
            }
        } else {
            return false
        }
    }

    return if (!exponent) {
        initialNumber
    } else {
        finalInt
    }
}

private fun isNumber2(s: String): Boolean {
    var decimalDigitsBeforeDot = false
    var decimalDot = false
    var decimalDigitsAfterDot = false
    var exponent = false
    var exponentIntegerDigits = false

    var i = 0
    while (i <= s.lastIndex) {
        when (s[i]) {
            'E', 'e' -> {
                if (exponent || (!decimalDigitsBeforeDot && !decimalDigitsAfterDot) || (i == s.lastIndex)) {
                    return false
                }
                exponent = true
                i++
            }
            '+', '-' -> {
                if (((i != 0) && (s[i - 1] != 'E') && (s[i - 1] != 'e')) || (i == s.lastIndex)) {
                    return false
                }
                i++
            }
            '.' -> {
                if (decimalDot || exponent) {
                    return false
                }
                decimalDot = true
                i++
            }
            in '0'..'9' -> {
                if (!decimalDigitsBeforeDot) {
                    decimalDigitsBeforeDot = true
                } else if (!decimalDigitsAfterDot) {
                    decimalDigitsAfterDot = true
                } else if (!exponentIntegerDigits) {
                    exponentIntegerDigits = true
                } else {
                    return false
                }
                while (i <= s.lastIndex && s[i].isDigit()) {
                    i++
                }
            }
            else -> {
                return false
            }
        }
    }
    return (decimalDigitsBeforeDot || decimalDigitsAfterDot)
}

/**
 * leetcode - https://leetcode.com/problems/valid-number/
 *
 * Using regex
 *
 * Stats
 * Runtime: 223 ms, faster than 7.41%
 * Memory Usage: 37.7 MB, less than 7.41%
 */
private fun isNumberUsingRegex(s: String): Boolean {
    val integerRegex = "(\\+|\\-)?\\d+"
    val decimalRegex = "(\\+|\\-)?(\\d+\\.|\\d+\\.\\d+|\\.\\d+)"
    return s.matches("(($integerRegex)|($decimalRegex))((e|E)($integerRegex))?".toRegex())
}

private fun main() {

}
