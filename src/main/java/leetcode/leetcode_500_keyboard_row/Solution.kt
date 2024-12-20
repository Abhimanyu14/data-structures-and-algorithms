package leetcode.leetcode_500_keyboard_row

/**
 * leetcode - https://leetcode.com/problems/keyboard-row/
 *
 * Data Structure - Set
 * Algorithm - Hashing
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 95.83%
 * Memory Usage: 35 MB, less than 91.67%
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun findWords(words: Array<String>): Array<String> {
    val result = mutableListOf<String>()
    fun getRow(char: Char): Int {
        return when (char.lowercaseChar()) {
            'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' -> 1
            'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' -> 2
            else -> 3
        }
    }

    val currentSet = mutableSetOf<Int>()
    for (word in words) {
        currentSet.clear()
        for (char in word) {
            currentSet.add(getRow(char))
            if (currentSet.size == 2) {
                break
            }
        }
        if (currentSet.size == 1) {
            result.add(word)
        }
    }
    return result.toTypedArray()
}

private fun main() {

}
