package leetcode.leetcode_1209_remove_all_adjacent_duplicates_in_string_ii

/**
 * leetcode - https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 *
 * Data Structure - [ArrayDeque] (Stack)
 * Algorithm - Stacking
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
private fun removeDuplicates(s: String, k: Int): String {
    val stack = ArrayDeque<Pair<Char , Int>>()
    for (char in s) {
        if (stack.isNotEmpty() && stack.last().first == char) {
            val (currentChar, count) = stack.removeLast()
            if (count + 1 != k) {
                stack.addLast(Pair(currentChar, count + 1))
            }
        } else {
            stack.addLast(Pair(char, 1))
        }
    }
    val result = StringBuilder()
    while (stack.isNotEmpty()) {
        val (char, count) = stack.removeLast()
        repeat(count) {
            result.insert(0, char)
        }
    }
    return result.toString()
}

private fun main() {

}
