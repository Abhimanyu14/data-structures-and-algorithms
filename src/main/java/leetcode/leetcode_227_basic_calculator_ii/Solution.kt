package leetcode.leetcode_227_basic_calculator_ii

/**
 * leetcode - https://leetcode.com/problems/basic-calculator-ii/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 *
 * Data Structure - [ArrayDeque] (Stack)
 * Algorithm -
 *
 * String methods - [isDigit], [digitToInt]
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun calculate(s: String): Int {
    var index = 0
    fun getNextNum(): Int {
        var num = 0
        while (index <= s.lastIndex && s[index].isDigit()) {
            num = (num * 10) + s[index].digitToInt()
            index++
        }
        return num
    }
    fun skipSpaces() {
        while (index <= s.lastIndex && s[index] == ' ') {
            index++
        }
    }
    val stack = ArrayDeque<Int>()
    while (index <= s.lastIndex) {
        skipSpaces()
        if (s[index] == '-') {
            index++
            skipSpaces()
            stack.addLast(-1 * getNextNum())
        } else if (s[index] == '+') {
            index++
            skipSpaces()
            stack.addLast(getNextNum())
        } else if (s[index] == '*') {
            index++
            skipSpaces()
            val prev = stack.removeLast()
            stack.addLast(prev * getNextNum())
        } else if (s[index] == '/') {
            index++
            skipSpaces()
            val prev = stack.removeLast()
            stack.addLast(prev / getNextNum())
        } else {
            stack.addLast(getNextNum())
        }
        skipSpaces()
    }
    var result = 0
    while (stack.isNotEmpty()) {
        result += stack.removeLast()
    }
    return result
}

private fun main() {

}
