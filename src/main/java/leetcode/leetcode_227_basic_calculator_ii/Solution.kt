package leetcode.leetcode_227_basic_calculator_ii

/**
 * leetcode - https://leetcode.com/problems/basic-calculator-ii/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 *
 * Data Structure - Two Pointers
 * Algorithm - Iteration
 *
 * String methods - [isDigit], [digitToInt]
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
private fun calculate(s: String): Int {
    var result = 0
    var index = 0
    var prev = 0
    var current = 0

    fun skipSpaces() {
        while (index <= s.lastIndex && s[index] == ' ') {
            index++
        }
    }

    fun getNextNum() {
        skipSpaces()
        current = 0
        while (index <= s.lastIndex && s[index].isDigit()) {
            current = (current * 10) + s[index].digitToInt()
            index++
        }
    }

    while (index <= s.lastIndex) {
        skipSpaces()
        if (s[index] == '-') {
            index++
            getNextNum()
            result += prev
            prev = current * -1
        } else if (s[index] == '+') {
            index++
            getNextNum()
            result += prev
            prev = current
        } else if (s[index] == '*') {
            index++
            getNextNum()
            prev *= current
        } else if (s[index] == '/') {
            index++
            getNextNum()
            prev /= current
        } else {
            getNextNum()
            prev = current
        }
        skipSpaces()
    }
    return result + prev
}

/**
 * leetcode - https://leetcode.com/problems/basic-calculator-ii/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 *
 * Data Structure - [ArrayDeque] (Stack)
 * Algorithm - Stack
 *
 * String methods - [isDigit], [digitToInt]
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
private fun calculateWithStack(s: String): Int {
    var result = 0
    var index = 0
    val stack = ArrayDeque<Int>()

    fun skipSpaces() {
        while (index <= s.lastIndex && s[index] == ' ') {
            index++
        }
    }

    fun getNextNum(): Int {
        skipSpaces()
        var num = 0
        while (index <= s.lastIndex && s[index].isDigit()) {
            num = (num * 10) + s[index].digitToInt()
            index++
        }
        return num
    }

    while (index <= s.lastIndex) {
        skipSpaces()
        if (s[index] == '-') {
            index++
            stack.addLast(-1 * getNextNum())
        } else if (s[index] == '+') {
            index++
            stack.addLast(getNextNum())
        } else if (s[index] == '*') {
            index++
            val prev = stack.removeLast()
            stack.addLast(prev * getNextNum())
        } else if (s[index] == '/') {
            index++
            val prev = stack.removeLast()
            stack.addLast(prev / getNextNum())
        } else {
            stack.addLast(getNextNum())
        }
        skipSpaces()
    }
    while (stack.isNotEmpty()) {
        result += stack.removeLast()
    }
    return result
}

private fun main() {

}
