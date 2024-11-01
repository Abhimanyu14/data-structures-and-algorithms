package leetcode.leetcode_316_remove_duplicate_letters

/**
 * leetcode - https://leetcode.com/problems/remove-duplicate-letters/
 *
 * Using monotonic stack, set and map
 *
 * Stats
 * Runtime: 173 ms, faster than 77.27%
 * Memory Usage: 35.7 MB, less than 90.91%
 */
private fun removeDuplicateLetters(s: String): String {
    val stack = ArrayDeque<Char>()
    val inStack = mutableSetOf<Char>()
    val lastOccurrence = mutableMapOf<Char, Int>()
    s.forEachIndexed { index, value ->
        lastOccurrence[value] = index
    }
    s.forEachIndexed { index, value ->
        if (!inStack.contains(value)) {
            while (stack.isNotEmpty() &&
                value < stack.last() &&
                lastOccurrence.getOrDefault(stack.last(), 0) > index
            ) {
                inStack.remove(stack.removeLast())
            }
            inStack.add(value)
            stack.addLast(value)
        }
    }
    return stack.joinToString("")
}

private fun main() {

}
