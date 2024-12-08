package leetcode.leetcode_1859_sorting_the_sentence

/**
 * leetcode - https://leetcode.com/problems/sorting-the-sentence/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - SortedMap and StringBuilder
 * Algorithm - Iteration
 *
 * StringBuilder Operations - [isNotEmpty], [length] and [insert]
 * Char Operations - [isDigit]
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 149 ms, faster than 100.00%
 * Memory Usage: 36.7 MB, less than 100.00%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun sortSentence(s: String): String {
    val result = StringBuilder()
    val map = sortedMapOf<Int, Int>()
    for (i in s.lastIndex downTo 0) {
        if (s[i].isDigit()) {
            map[s[i] - '0'] = i
        }
    }
    var index: Int
    var insertIndex: Int
    for ((_, value) in map) {
        index = value - 1
        if (result.isNotEmpty()) {
            result.append(' ')
        }
        insertIndex = result.length
        while (index >= 0 && s[index] != ' ') {
            result.insert(insertIndex, s[index])
            index--
        }
    }
    return result.toString()
}

private fun main() {

}
