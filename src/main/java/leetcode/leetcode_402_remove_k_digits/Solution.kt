package leetcode.leetcode_402_remove_k_digits

import java.util.Stack

/**
 * leetcode - https://leetcode.com/problems/remove-k-digits/?envType=daily-question&envId=2024-04-11
 *
 * TODO(Abhi) - To revisit
 *
 * Using monotonic stack
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 525 ms, faster than 24.24%
 * Memory Usage: 42.6 MB, less than 6.06%
 *
 * Time -
 * Space -
 */
private fun removeKdigits(num: String, k: Int): String {
    val stack = Stack<Char>()
    var k = k

    num.forEach { n ->
        while (k > 0 && stack.isNotEmpty() && stack.peek() > n) { stack.pop(); k-- }
        stack += n
    }

    repeat(k) {
        stack.pop()
    }

    return if (stack.isEmpty()) "0" else stack.joinToString("").toBigInteger().toString()
}

private fun main() {

}
