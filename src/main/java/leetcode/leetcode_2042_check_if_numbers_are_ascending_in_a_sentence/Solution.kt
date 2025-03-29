package leetcode.leetcode_2042_check_if_numbers_are_ascending_in_a_sentence

/**
 * leetcode - https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/description/
 *
 * Data Structure - [String]
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies -
 */
private fun areNumbersAscending(s: String): Boolean {
    var index = 0
    fun getNextNum(): Int? {
        while (index <= s.lastIndex && !s[index].isDigit()) {
            index++
        }
        if (index > s.lastIndex) {
            return null
        }
        var result = 0
        while (index <= s.lastIndex && s[index].isDigit()) {
            result = (result * 10) + s[index].digitToInt()
            index++
        }
        return result
    }

    var prev = getNextNum() ?: return true
    var current: Int
    while (index <= s.lastIndex) {
        current = getNextNum() ?: return true
        if (current <= prev) {
            return false
        }
        prev = current
    }
    return true
}

private fun main() {

}
