package leetcode.leetcode_682_baseball_game

/**
 * leetcode - https://leetcode.com/problems/baseball-game/description/
 *
 * Data Structure - [ArrayDeque] (Stack)
 * Algorithm - Stack
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun calPoints(operations: Array<String>): Int {
    val stack = ArrayDeque<Int>()
    for (i in operations.indices) {
        when (operations[i]) {
            "+" -> {
                val last = stack.removeLast()
                val sum = stack.last() + last
                stack.addLast(last)
                stack.addLast(sum)
            }

            "D" -> {
                stack.addLast(stack.last() * 2)
            }

            "C" -> {
                stack.removeLast()
            }

            else -> {
                stack.addLast(operations[i].toInt())
            }
        }
    }
    var result = 0
    while (stack.isNotEmpty()) {
        result += stack.removeLast()
    }
    return result
}

private fun main() {

}
