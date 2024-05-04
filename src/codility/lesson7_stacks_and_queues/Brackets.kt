package codility.lesson7_stacks_and_queues

/**
 * Time complexity - O(N)
 */
private fun solution(S: String): Int {
    val map = mapOf(
        ')' to '(',
        ']' to '[',
        '}' to '{',
    )
    val stack = ArrayDeque<Char>()
    S.forEach { char ->
        if (map.contains(char)) {
            if (stack.isEmpty() || stack.last() != map[char]) {
                return 0
            } else {
                stack.removeLast()
            }
        } else {
            stack.addLast(char)
        }
    }
    return if (stack.isEmpty()) {
        1
    } else {
        0
    }
}
