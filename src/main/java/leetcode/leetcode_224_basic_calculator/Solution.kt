package leetcode.leetcode_224_basic_calculator

/**
 * leetcode - https://leetcode.com/problems/basic-calculator/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Recursion
 *
 * Difficulty - Hard
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Google, Meta
 */
private fun calculate(s: String): Int {
    var index = 0
    fun skipSpaces() {
        while (index <= s.lastIndex && s[index] == ' ') {
            index++
        }
    }

    fun getNextNum(): Int {
        var num = 0
        while (index <= s.lastIndex && s[index].isDigit()) {
            num = (num * 10) + s[index].digitToInt()
            index++
        }
        return num
    }

    fun getResult(): Int {
        var result = 0
        var sign = 1
        while (index <= s.lastIndex) {
            skipSpaces()
            if (s[index] == '+') {
                index++
            } else if (s[index] == '-') {
                index++
                sign = -1
            } else if (s[index] == ')') {
                index++
                return result
            } else if (s[index] == '(') {
                index++
                result += sign * getResult()
                sign = 1
            } else {
                result += sign * getNextNum()
                sign = 1
            }
            skipSpaces()
        }
        return result
    }
    return getResult()
}

private fun main() {

}
